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

        stage('Create JAR file') {
            steps {
                sh 'ls -l target/*.jar'
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
