pipeline {
    agent any

    tools {
        maven 'Maven_3.9.5'
        jdk 'JDK-17'
    }

    environment {
        ALLURE_RESULTS = 'target\\allure-results'
        ALLURE_REPORT = 'target\\allure-report'
        ALLURE_HISTORY = 'allure-history'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo "Checking out source code"
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                echo "Cleaning..."
                bat 'mvn clean'
            }
        }

        stage('Run Smoke Tests') {
            steps {
                bat 'mvn test -DsuiteXmlFile=src\\test\\resources\\testng-smoke.xml'
            }
        }

        stage('Copy Allure History') {
            steps {
                echo "Copying previous Allure history..."
                bat '''
                if not exist allure-history (
                    mkdir allure-history
                )
                xcopy /E /I /Y target\\allure-results\\history allure-history
                '''
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo "Generating Allure Report..."
                bat 'allure generate target\\allure-results --clean -o target\\allure-report'
            }
        }

        stage('Archive Allure Report') {
            steps {
                archiveArtifacts artifacts: 'target/allure-report/**/*.*', onlyIfSuccessful: true
            }
        }
    }

    post {
        always {
            echo "Saving Allure History"
            bat '''
            if not exist target\\allure-report\\history (
                echo No history folder found in allure-report
            ) else (
                xcopy /E /I /Y target\\allure-report\\history allure-history
            )
            '''
        }
    }
}
