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
List the technologies and tools used in your project. This can include programming languages, frameworks, libraries, and any other relevant technologies.
