import boto3
from . import parameter_provider


class AWSClient:
    def __init__(self):
        self._ec2_resource = boto3.resource('ec2', region_name = parameter_provider.get_aws_region())

    def start_jenkins_instance(self):
        instance = self._ec2_resource.Instance(parameter_provider.get_jenkins_instance_id())

        instance.start()
        print(f'Starting Jenkins instance: {instance.id}')

        instance.wait_until_running()
        print(f'EC2 instance "{instance.id}" has been started')

    def stop_jenkins_instance(self):
        instance = self._ec2_resource.Instance(parameter_provider.get_jenkins_instance_id())

        instance.stop()
        print(f'Initialized stopping of Jenkins instance: {instance.id}')
