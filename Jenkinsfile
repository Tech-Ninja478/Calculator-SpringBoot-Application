pipeline{
    agent any

    options{
        timestamps()
        disableConcurrentBuilds()
    }

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
                sh '''
                    docker build \
                    --build-arg BUILD_NUMBER="${BUILD_NUMBER}" \
                    --build-arg GIT_COMMIT="${GIT_COMMIT}" \
                    -t calculator-api:${BUILD_NUMBER} .
                '''
            }
        }

        stage('Verify Docker Image'){
            steps{
                sh 'docker image inspect calculator-api:${BUILD_NUMBER}'
            }
        }

        stage('Push Docker Image'){
            steps{
                script{
                    withCredentials([
                        usernamePassword(
                            credentialsId: 'dockerhub-task6',
                            usernameVariable: 'DOCKER_USERNAME',
                            passwordVariable: 'DOCKER_PASSWORD'
                        )
                    ]){
                        sh '''
                            echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                            docker tag calculator-api:${BUILD_NUMBER} ${DOCKER_USERNAME}/calculator-api:${BUILD_NUMBER}
                            docker push ${DOCKER_USERNAME}/calculator-api:${BUILD_NUMBER}
                            docker logout
                        '''
                    }
                }
            }
        }
    }

    post{
        success{
            echo 'Pipeline completed successfully!'
        }

        failure{
            echo 'Pipeline failed. Check the console output.'
        }

        always{
            echo 'Pipeline execution completed.'
        }
    }
}