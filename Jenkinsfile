pipeline{
    agent any

    stages{
        stage('Checkout'){
            steps{
                checkout scm
            }
        }

        stage('Test'){
            steps{
                sh './mvnw test'
            }
        }

        stage('Build Docker Image'){
            steps{
                sh 'docker build -t calculator-api:${BUILD_NUMBER} .'
            }
        }
    }
}