pipeline {
	agent any
	
	stages {
		stage ('Code Compiler'){
			steps {
				withMaven(maven : 'localMaven'){
					sh 'mvn clean compile'
				}
			}
		}
		
		stage ('Test Stage') {
			steps {
				withMaven(maven: 'localMaven') {
					sh 'mvn test'
				}
			}
		}
		
		stage ('Deployment Stage') {
			steps {
				withMaven(maven: 'localMaven') {
					sh 'mvn deploy'
				}
			}
		}
	}
}