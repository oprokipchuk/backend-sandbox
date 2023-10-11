import urllib3
import time
from . import parameter_provider


class JobRetrySpecification:
    def __init__(self, max_attempts, delay):
        self.max_attempts = max_attempts
        self.delay = delay


class JenkinsClient:
    def __init__(self):
        self._http = urllib3.PoolManager()

    def start_create_cluster_job(self, retry_spec):
        return self._execute_with_retry(
            lambda: self._start_cluster_job('create'),
            retry_spec)

    def start_destroy_cluster_job(self, retry_spec):
        return self._execute_with_retry(
            lambda: self._start_cluster_job('destroy'),
            retry_spec)

    def _execute_with_retry(self, func, retry_spec = JobRetrySpecification(1, 0)):
        for attempt in range(1, retry_spec.max_attempts + 1):
            try:
                return func()
            except Exception as e:
                has_more_attempts = attempt < retry_spec.max_attempts
                if has_more_attempts:
                    print(f'Attempt #{attempt} failed. Retrying in {retry_spec.delay} seconds...')
                    time.sleep(retry_spec.delay)
                else:
                    raise e

    def _start_cluster_job(self, action):
        jenkins_url = parameter_provider.get_jenkins_url()
        job_name = parameter_provider.get_jenkins_job_name()
        job_token = parameter_provider.get_jenkins_job_token()

        fields = {
            'token': job_token,
            'job': job_name,
            'cause': 'Lambda+Function',
            'action': action,
        }

        response = self._http.request('POST', f'{jenkins_url}/buildByToken/buildWithParameters', fields=fields)
        status = response.status

        if not self._is_successful(status):
            raise RuntimeError(f'Cluster job [{job_name}] initialization has been failed with status [{status}]')

        print(f'Cluster Job [{job_name}] has been initialized '
              f'with action [{action}] and status [{status}]')
        return status

    def _is_successful(self, status):
        return 200 <= status <= 299
