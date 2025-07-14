pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN-3.9.10"
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/viveklabs/TestFramework.git'

            }

        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean install -DskipTests=true"
            }

        }
        stage('Test') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn test -Dtest=GenerateTestNGXMLAndRun1#TestRunner -Dmaven.test.failure.ignore=true"
            }

        }
    }
    post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
}
