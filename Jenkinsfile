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
		stage ('Test Stage') {
			steps {
				withMaven(maven: 'localMaven') {
					sh 'mvn test'
				}
			}
		}
		stage('Jacoco Build'){
			steps{
				step([$class: 'JacocoPublisher', 
      					execPattern: 'target/*.exec',
      					classPattern: 'target/classes',
      					sourcePattern: 'src/main/java',
      					exclusionPattern: 'src/test*'
				])
			}
		}
	}
}
