    def website = ''
    def threadCount = ''
    def buildBy = ''

    pipeline {
        agent any

        parameters {
        choice(name: 'Website' , choices: ['','Google','Facebook'])
        string(name: 'Thread_Count', choices: ['5','4','3','2','1'], description: 'Number of threads to use')
        string(name: 'Build_By', defaultValue: 'Vivek P')
        }

        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "MAVEN-3.9.10"
        }

        stages {

            stage ('Config') {
                steps {
                    script {
                        website = params.Website
                        threadCount = params.Thread_Count
                        buildBy = params.Build_By

                        echo "Website Name: ${website}"
                        echo "Thread Count: ${threadCount}"
                        echo "Build By: ${buildBy}"
                    }
                }
            }
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
                    sh "mvn test -Dtest=GenerateTestNGXMLAndRun1#TestRunner -Dmaven.test.failure.ignore=true -Dwebsite=${website} -DthreadCount=${threadCount} -DbuildBy=${buildBy}"
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
