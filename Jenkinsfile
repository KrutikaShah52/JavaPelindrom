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
	
	post {
    	always {
      		archive "target/**/*"
        	junit 'target/surefire-reports/*.xml'
       	}
   	}
}

