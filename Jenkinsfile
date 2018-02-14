pipeline {
	def server = Artifactory.newServer url: SERVER_URL, credentialsId: CREDENTIALS
	def rtMaven = Artifactory.newMavenBuild()
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
			
		stage ('Artifactory configuration') {
			steps {
				rtMaven.tool = 'Maven'
				rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
				rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
				def buildInfo = Artifactory.newBuildInfo() 
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
				server.publishBuildInfo buildInfo
				}
			}
	}
}