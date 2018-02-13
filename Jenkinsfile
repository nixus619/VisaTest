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
			post {
                always {
                    //generate cucumber reports
                    cucumber '**/*.json'
                }
            }
			}
			
		stage ('Testing Stage') {
			steps {
				withMaven(maven : 'Maven') {
					bat 'mvn test'
				}
			}
		}
		
		stage ('Deployment Stage') {
			steps {
				echo 'Deploy here'
				}
			}
	}
}