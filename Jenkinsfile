pipeline {
	agent any
	tools {
		jdk 'localJDK' 
		maven 'localMaven'
    	}
	stages {
		stage ('Code Compiler'){
			steps {
				withMaven(maven : 'localMaven'){
					sh 'mvn clean install'
				}
			}
		}
	}
}
