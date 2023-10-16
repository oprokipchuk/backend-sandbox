# Backend Sandbox

## Overview
This project was created to reproduce a microservices application's production environment using the most modern technologies and methodologies.

> *All diagrams here are clickable and editable. You can view and edit them by clicking on the diagrams below.*

## Application
Currently, the application consists of only a hello-world Spring Boot application running in a Kubernetes cluster.

### Application Diagram
[![Application Diagram](https://github.com/oprokipchuk/backend-sandbox/blob/master/diagrams/application.drawio.svg?raw=true)](https://viewer.diagrams.net/?tags=%7B%7D&target=blank&highlight=0000ff&edit=https%3A%2F%2Fapp.diagrams.net%2F%23Hoprokipchuk%252Fbackend-sandbox%252Fmaster%252Fdiagrams%252Fapplication.drawio.svg&layers=1&nav=1&title=application.drawio.svg#Uhttps%3A%2F%2Fraw.githubusercontent.com%2Foprokipchuk%2Fbackend-sandbox%2Fmaster%2Fdiagrams%2Fapplication.drawio.svg)

## CI-CD
CI-CD processes of the application include two main items:
- The pipeline of creating/destroying the EKS cluster saves money by running the cluster only when needed.
- The second pipeline is a CI pipeline, which continuously reads changes, builds the code, and deploys the application. 

### CI-CD Diagram
[![CI-CD Diagram](https://github.com/oprokipchuk/backend-sandbox/blob/master/diagrams/ci-cd.drawio.svg?raw=true)](https://viewer.diagrams.net/?tags=%7B%7D&highlight=000000&edit=https%3A%2F%2Fapp.diagrams.net%2F%23Hoprokipchuk%252Fbackend-sandbox%252Fmaster%252Fdiagrams%252Fci-cd.drawio.svg&layers=1&nav=1&title=ci-cd.drawio.svg#Uhttps%3A%2F%2Fraw.githubusercontent.com%2Foprokipchuk%2Fbackend-sandbox%2Fmaster%2Fdiagrams%2Fci-cd.drawio.svg)

## Infrastructure
The application and all the used tools, including Jenkins are hosted on AWS cloud.

### Infrastructure Diagram
[![Infrastructure Diagram](https://github.com/oprokipchuk/backend-sandbox/blob/master/diagrams/infrastructure.drawio.svg?raw=true)](https://viewer.diagrams.net/?tags=%7B%7D&target=blank&highlight=0000ff&edit=https%3A%2F%2Fapp.diagrams.net%2F%3Flibs%3Dgeneral%3Baws4%23Hoprokipchuk%252Fbackend-sandbox%252Fmaster%252Fdiagrams%252Finfrastructure.drawio.svg&layers=1&nav=1&title=infrastructure.drawio.svg#Uhttps%3A%2F%2Fraw.githubusercontent.com%2Foprokipchuk%2Fbackend-sandbox%2Fmaster%2Fdiagrams%2Finfrastructure.drawio.svg)

## Technologies
Here is the list of the technologies used in this sandbox.

Applications:
- Backend Service:
  - Spring Boot
  - Maven
- Lambda cluster controls:
  - Python
  - Serverless 

Tools:
- Docker:
  - Multi-Platform image build
  - DockerHub repo
  - Running containers
  - Volumes
  - Clearing resources out
- Kubernetes:
  - Configuring kube-contexts
  - Applying/deleting file-resources
  - Triggering external resources through Kubernetes configuration and annotations
- Jenkins:
  - Hosted on EC2
  - Docker Agents
  - Groovy pipeline definitions in SCM
  - SCM Webhook and REST triggers
  - Email notifications
- Terraform:
  - AWS and Kubernetes providers
  - Environment variables
  - Remote backend
  - Full automation
- Serverless:
  - AWS provider
  - Multiple lambdas per config
  - Configuring API Gateway with an API Key
- SSH (connecting to EC2)
- Ubuntu bash

AWS Services and Resources:
- IAM:
  - Users
  - Roles
  - Policies
- Networking:
  - VPC
  - Subnets
  - Security Groups
  - Internet Gateway
  - Elastic IP
  - Routing Table
  - Route53 DNS Record, Hosted Zone, Rules
  - AWS Certificate Manager cert for HTTPS
- Storage:
  - S3 Buckets
  - EBS volumes
- Compute:
  - EC2
  - EKS on EC2
  - Lambda
- Facing Public Traffic:
  - Classic Load Balancer
  - API Gateway to Lambda (API key, stage, custom domain, HTTPS)
