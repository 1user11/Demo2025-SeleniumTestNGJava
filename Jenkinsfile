pipeline {
    agent any

    tools {
        maven 'Maven_3.9.5'
        jdk 'JDK-17'
        allure 'allure-2.24.0'
    }

    environment {
        ALLURE_RESULTS = 'target/allure-results'
        ALLURE_REPORT = 'target/allure-report'
        ALLURE_HISTORY = 'allure-history'
        SCREENSHOTS = 'target/screenshots'
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
                echo "Cleaning project"
                bat 'mvn clean'
            }
        }

        stage('Run Smoke Tests') {
            steps {
                echo "Running Smoke Tests"
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    bat 'mvn test -DsuiteXmlFile=src\\test\\resources\\testng-smoke.xml'
                }
            }
        }

        stage('Copy Allure History') {
            steps {
                echo "Copying Allure History (if any)"
                bat '''
                if exist allure-history (
                    echo Copying existing history to results
                    xcopy /E /I /Y allure-history target\\allure-results\\history
                ) else (
                    echo No previous history to copy
                )
                '''
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo "🧾 Generating Allure Report"
                bat 'allure generate target\\allure-results --clean -o target\\allure-report'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo "📦 Archiving Allure report and screenshots"
                archiveArtifacts artifacts: 'target/allure-report/**/*.*', onlyIfSuccessful: false
                archiveArtifacts artifacts: 'target/screenshots/**/*.*', onlyIfSuccessful: false, allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Saving Allure History for Next Build"
            bat '''
            if exist target\\allure-report\\history (
                xcopy /E /I /Y target\\allure-report\\history allure-history
            ) else (
                echo No history folder found in allure-report
            )
            '''

            echo "Publishing Allure Report"
            allure([
                jdk: 'JDK-17',
                commandline: 'allure-2.24.0',
                results: [[path: "target/allure-results"]],
                reportBuildPolicy: 'ALWAYS'
            ])
        }

        failure {
            echo "Build failed — tests or setup issue detected."
        }

        success {
            echo "Build succeeded — all smoke tests passed."
        }
    }
}

