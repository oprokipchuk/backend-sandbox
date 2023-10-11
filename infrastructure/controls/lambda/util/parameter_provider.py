import os


def get_env_variable(name):
    return os.environ.get(name)


def get_aws_region():
    return get_env_variable('REGION')


def get_jenkins_instance_id():
    return get_env_variable('JENKINS_INSTANCE_ID')


def get_jenkins_url():
    return get_env_variable('JENKINS_URL')


def get_jenkins_job_name():
    return get_env_variable('JENKINS_JOB_NAME')


def get_jenkins_job_token():
    return get_env_variable('JENKINS_JOB_TOKEN')
