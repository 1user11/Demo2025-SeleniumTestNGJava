pipeline {
    agent any

    tools {
        maven 'Maven_3.9.5'
        jdk 'JDK-17'
    }

    environment {
        PROJECT_DIR = 'Demo2025-SeleniumTestNGJava'
        ALLURE_RESULTS = 'target/allure-results'
        ALLURE_REPORT = 'target/allure-report'
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
                dir("${env.PROJECT_DIR}") {
                    bat 'mvn clean'
                }
            }
        }

        stage('Run Smoke Tests') {
            steps {
                echo "Running Smoke Tests"
                dir("${env.PROJECT_DIR}") {
                    bat 'mvn test -DsuiteXmlFile=src\\test\\resources\\testng-smoke.xml'
                }
            }
        }

        stage('Copy Allure History') {
            steps {
                echo "Copying Allure History"
                dir("${env.PROJECT_DIR}") {
                    bat '''
                    if not exist allure-history (
                        mkdir allure-history
                    )
                    xcopy /E /I /Y target\\allure-results\\history allure-history
                    '''
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo "Generating Allure Report"
                dir("${env.PROJECT_DIR}") {
                    bat 'allure generate target\\allure-results --clean -o target\\allure-report'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo "Archiving Allure Report"
                dir("${env.PROJECT_DIR}") {
                    archiveArtifacts artifacts: 'target/allure-report/**/*.*', onlyIfSuccessful: true
                }
            }
        }
    }

    post {
        always {
            echo "Saving Allure History for Next Build"
            dir("${env.PROJECT_DIR}") {
                bat '''
                if not exist target\\allure-report\\history (
                    echo "No history folder found in allure-report"
                ) else (
                    xcopy /E /I /Y target\\allure-report\\history allure-history
                )
                '''
            }
        }

        success {
            echo "Publishing Allure Report"
            allure([
                includeProperties: false,
                jdk: 'JDK-17',
                results: [[path: "${env.PROJECT_DIR}/target/allure-results"]],
                reportBuildPolicy: 'ALWAYS'
            ])
        }
    }
}
