pipeline {
    agent any

    tools {
        maven 'Maven_3.9.5'
        jdk 'JDK-17'
    }

    environment {
        ALLURE_RESULTS = 'target\\allure-results'
        ALLURE_HISTORY = 'allure-history'
        ALLURE_REPORT = 'target\\allure-report'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo "Checking out code..."
                checkout scm
            }
        }

        stage('Clean Project') {
            steps {
                dir('Demo2025-SeleniumTestNGJava') {
                    bat 'mvn clean'
                }
            }
        }

        stage('Run Smoke Tests') {
            steps {
                dir('Demo2025-SeleniumTestNGJava') {
                    bat 'mvn test -DsuiteXmlFile=src\\test\\resources\\testng-smoke.xml'
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                dir('Demo2025-SeleniumTestNGJava') {
                    echo "Generating Allure Report..."
                    bat 'allure generate target\\allure-results --clean -o target\\allure-report'
                }
            }
        }

        stage('Copy Allure History') {
            steps {
                dir('Demo2025-SeleniumTestNGJava') {
                    bat '''
                    if exist allure-history (
                        xcopy /s /e /y allure-history
