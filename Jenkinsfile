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
	}
}