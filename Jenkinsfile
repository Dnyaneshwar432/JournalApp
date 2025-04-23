pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build WAR') {
            steps {
                echo 'Building WAR using Maven...'
                sh 'mvn clean install'
            }
        }

        stage('List WAR file') {
            steps {
                sh 'ls -l target/*.war'
            }
        }
    }

    post {
        success {
            echo '🎉 Build successful!'
        }
        failure {
            echo '💥 Build failed!'
        }
    }
}
