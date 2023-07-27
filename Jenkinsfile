stage('Run Container') {
    steps {
        // Запуск контейнера из образа
        script {
            dockerImage.run("-p 8080:80 -v /путь/к/локальной/конфигурационной/папке:/configuration -d")
        }
    }
}
