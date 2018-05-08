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
	}
}
