pipeline {
	agent any
	
	stages {
		stage ('Compile Stage') {
			steps {
				withMaven(maven :'Maven') {
					call 'mvn clean compile'
					}
				}
			}
			
		stage ('Testing Stage') {
			steps {
				withMaven(maven : 'Maven') {
					call 'mvn test'
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