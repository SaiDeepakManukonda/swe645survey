pipeline {
    agent any

    tools {
        maven 'Default'  // Make sure this matches Jenkins > Global Tool Config > Maven name
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/SaiDeepakManukonda/swe645survey.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Build and package completed successfully!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
