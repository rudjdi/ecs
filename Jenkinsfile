pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'building now'
                withGradle()
                {
                    sh '.gradlew clean'
                    sh '.gradlew build'
                }
            }
        }
    }
}
