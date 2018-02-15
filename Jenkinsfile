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
						}
						} catch (Exception e) {
							currentBuild.result = 'FAILURE'
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
				echo 'Deploy here'
				}
			}
	}
}