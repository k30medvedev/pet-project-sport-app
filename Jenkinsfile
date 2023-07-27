stage('Run Container') {
    steps {
        // Запуск контейнера из образа
        sh 'docker run -p 8080:80 -v /путь/к/локальной/конфигурационной/папке:/configuration -d my-docker-image:${env.BUILD_NUMBER}'
    }
}

