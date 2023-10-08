def PROJECT_PATH = 'domainless/hello-world'
def TERRAFORM_PATH = 'infrastructure/automated/eks'

def isCreateAction() {
    return action == "create"
}

def TERRAFORM_ACTION = isCreateAction() ? "apply" : "destroy"
echo "Running with terraform action: ${TERRAFORM_ACTION}"

pipeline {
    agent {
        docker {
            image 'oprokipchuk/backend-sandbox-cicd:latest'
            args '-u root'
            alwaysPull true
        }
    }

    stages {
        stage('Terraform: Init') {
            steps {
                dir(TERRAFORM_PATH) {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform: Validate') {
            steps {
                dir(TERRAFORM_PATH) {
                    sh 'terraform validate'
                }
            }
        }
        stage('Terraform: Action') {
            steps {
                dir(TERRAFORM_PATH) {
                    sh "terraform ${TERRAFORM_ACTION} -var="cluster_name=${env.EKS_CLUSTER_NAME}" --auto-approve"
                }
            }
        }
        stage('Kubernetes: Resources') {
            steps {
                script {
                    if (isCreateAction()) {
                        def K8S_FILE_PATH = "${PROJECT_PATH}/ci-cd/k8s.yml"

                        sh "aws eks update-kubeconfig --name ${env.EKS_CLUSTER_NAME} --region ${env.AWS_REGION}"
                        sh "kubectl apply -f ${K8S_FILE_PATH}"
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
            mail to: "${env.ADMIN_EMAIL}",
                 subject: "Build #${BUILD_NUMBER}: Success",
                 body: "The EKS cluster's action [${TERRAFORM_ACTION}] has been done successfully."
        }
        unsuccessful {
            echo 'Build failed!'
            mail to: "${env.ADMIN_EMAIL}",
                 subject: "Build #${BUILD_NUMBER}: Failure",
                 body: "The EKS cluster's action [${TERRAFORM_ACTION}] has been failed."
        }
    }
}
