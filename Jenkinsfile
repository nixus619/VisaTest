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
				withMaven(maven : 'Maven') {
					bat 'mvn test'
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
				echo 'Deploy here'
				withArtifactory(Artifactory : 'Artifactory') {
					}
				}
			}
	}
}