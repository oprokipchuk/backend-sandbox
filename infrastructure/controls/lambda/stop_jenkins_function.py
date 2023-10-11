from util.aws_client import AWSClient
from util import responses

aws_client = AWSClient()


def lambda_handler(event, context):
    aws_client.stop_jenkins_instance()

    return responses.SUCCESS
