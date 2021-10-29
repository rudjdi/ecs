pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                gradlew clean build
            }
        }
        stage('Test') {
            steps {
                gradle test --tests CarApplicationTests
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
