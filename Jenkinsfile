pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                // Сборка Docker образа
                script {
                    def dockerImage = docker.build("my-docker-image:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Run Container') {
            steps {
                // Запуск контейнера из образа
                script {
                    dockerImage.run("-p 8080:80 -d")
                }
            }
        }
    }
}
