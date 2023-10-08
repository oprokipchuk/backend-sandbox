def PROJECT_PATH = 'domainless/hello-world'
def APP_NAME = 'hello-world'

pipeline {
    agent {
        docker {
            image 'oprokipchuk/backend-sandbox-cicd:latest'
            args '-u root'
            alwaysPull true
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
            mail to: "${env.ADMIN_EMAIL}",
                 subject: "Test Success Email",
                 body: "Test Success ${action}"
        }

        unsuccessful {
            echo 'Build failed!'
            mail to: "${env.ADMIN_EMAIL}",
                 subject: "Test Success Email",
                 body: "Test Success ${action}"
        }
    }
}
