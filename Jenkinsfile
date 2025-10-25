pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk17'
    }

    environment {
        CHROME_OPTIONS = '--headless=new --window-size=1920,1080 --disable-gpu --no-sandbox --disable-dev-shm-usage'
        CI_RUN = 'true'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/1user11/Demo2025-SeleniumTestNGJava.git'
            }
        }

        stage('Clean Workspace') {
            steps {
                sh 'mvn clean'
                sh 'rm -rf screenshots || true'
                sh 'mkdir -p screenshots'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: 'jdk17', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'screenshots/*.png', allowEmptyArchive: true
        }
        failure {
            echo 'Some tests failed.'
        }
    }
}
