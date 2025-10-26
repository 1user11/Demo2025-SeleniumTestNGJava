pipeline {
    agent any

    tools {
        maven 'Maven_3.9.5'
        jdk 'JDK-17'
    }

    environment {
        PROJECT_DIR = '.'
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
                echo "Cleaning project..."
                bat 'mvn clean'
            }
        }

        stage('Copy Allure History') {
            steps {
                echo "🕘 Copying previous Allure history..."
                bat '''
                if exist target\\allure-results\\history (
                    xcopy /E /I /Y target\\allure-results\\history allure-history
                ) else (
                    echo "No previous Allure history to copy"
                )
                '''
            }
        }

        stage('Run Smoke Tests') {
            steps {
                echo "Running Smoke Tests..."
                bat 'mvn test -DsuiteXmlFile=src\\test\\resources\\testng-smoke.xml'
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
                echo "Archiving Allure Report"
                archiveArtifacts artifacts: 'target/allure-report/**/*.*', onlyIfSuccessful: true
            }
        }
    }

    post {
        always {
            echo "💾 Saving Allure History for next build"
            bat '''
            if exist target\\allure-report\\history (
                xcopy /E /I /Y target\\allure-report\\history allure-history
            ) else (
                echo "No history folder found in allure-report"
            )
            '''

            archiveArtifacts artifacts: 'allure-history/**/*.*', fingerprint: true
        }
    }
}
