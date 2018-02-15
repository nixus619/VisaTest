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
							mystage = "pass"
							}
						} catch (Exception e) {
							echo '[FAILURE] Test cases did not all pass. See Cucumber results'
							currentBuild.result = 'FAILURE'
							mystage = "fail"
							}
						}
					}
			post {
                always {
                    //generate cucumber reports
                    cucumber '**/*.json'
                	}
           		}
		}
		
		stage ('Deployment Stage') {
			echo $mystage
			when {
			expression { mystage == 'pass'}
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
	}
}