pipeline {
    agent {
        docker {
            image 'maven:3.9.6-amazoncorretto-17'
            args '-v $HOME/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock'
            reuseNode true
        }
    }

    environment {
        SPRING_DATASOURCE_URL = 'jdbc:postgresql://localhost:5432/testdb'
        SPRING_DATASOURCE_USERNAME = 'postgres'
        SPRING_DATASOURCE_PASSWORD = 'postgres'
    }

    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
        }
    }
}
