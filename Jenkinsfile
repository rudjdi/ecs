pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'building now'
                withGradle()
                {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean'
                    sh './gradlew build'
                }
            }
        }
    }
}
