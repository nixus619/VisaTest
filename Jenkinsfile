pipeline {
	agent any
	tools {
		jdk 'JDK'
	}
	step([$class: 'CucumberReportPublisher', jsonReportDirectory: "./Build/temp/", jenkinsBasePath: '', fileIncludePattern: 'reports.json'])
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
		}
		
		stage ('Deployment Stage') {
			steps {
				echo 'Deploy here'
				}
			}
	}
}