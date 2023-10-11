from util.aws_client import AWSClient
from util.jenkins_client import JenkinsClient, JobRetrySpecification
from util import responses

aws_client = AWSClient()
jenkins_client = JenkinsClient()


def lambda_handler(event, context):
    aws_client.start_jenkins_instance()
    jenkins_client.start_destroy_cluster_job(JobRetrySpecification(max_attempts = 8, delay = 5))

    return responses.SUCCESS
