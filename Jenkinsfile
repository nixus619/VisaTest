pipeline {
	agent any
	tools {
		jdk 'JDK'
	}
	stages {
		stage ('Compile Stage') {
			steps {
				withMaven(maven :'Maven') {
					bat 'mvn clean compile'
					}
				}
			}
			
		stage ('Testing Stage') {
			steps {
				script { 
					try {
						withMaven(maven : 'Maven') {
							bat 'mvn test'
							mystage = "Pass"
							}
						} catch (Exception e) {
							echo '[FAILURE] Test cases did not all pass. See Cucumber results'
							currentBuild.result = 'FAILURE'
							mystage = "Fail"
							}
						}
					}
			post {
                always {
                    //generate cucumber reports
                    cucumber '**/*.json'
                    // Echo stage fail or pass
                    echo 'Current Stage is:'
                    echo mystage
                	}
           		}
		}
		
		stage ('Deployment Stage') {
			when {
				expression { mystage == 'Pass'}
				}
			steps {
			script {
				def server = Artifactory.server 'Artifactory'
				server.username = 'admin'
				server.password = 'admin'
				def uploadSpec = """{
					"files": [
						{
							"pattern": "**.txt",
							"target": "libs-snapshot-local"
						}
					]
				}"""
				server.upload(uploadSpec)
				}
			}
		}
		
		stage ('Failure Stage') {
			when {
					// If mystage is fail, then write to log
					expression { mystage == 'Fail' }
				}
			steps {
					echo 'Fall back steps after a failed build will go here'
					echo 'Will not deploy any code to artifactory '
			}
		}
	}
}