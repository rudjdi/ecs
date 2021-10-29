pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                ./gradlew clean
                ./gradlew build
            }
        }
        stage('Test') {
            steps {
                ./gradlew test --tests CarApplicationTests
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
