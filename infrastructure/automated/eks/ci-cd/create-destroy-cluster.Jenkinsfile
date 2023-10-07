def PROJECT_PATH = 'domainless/hello-world'
def APP_NAME = 'hello-world'

pipeline {
    agent {
        docker {
            image 'oprokipchuk/backend-sandbox-cicd:latest'
            args '-u root'
        }
    }

    stages {
        stage('Test Echo') {
            steps {
                sh 'ls'
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
