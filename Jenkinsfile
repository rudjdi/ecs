pipeline {
    agent any
    tools{
        gradle 'gradle7.2'
    }
    stages {
        stage('Build') {
            steps {
                echo 'building now'
                sh 'chmod +x ./gradlew'
                sh './gradlew clean'
                sh './gradlew build -x test'
            }
        }
    }
}
