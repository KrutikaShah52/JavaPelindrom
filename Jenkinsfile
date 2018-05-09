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
		
		stage('Cobertura Build'){
			steps{
				step([$class: 'CoberturaPublisher', 
						autoUpdateHealth: false, 
						autoUpdateStability: false, 
						coberturaReportFile: '**/target/site/cobertura/coverage.xml', 
						failUnhealthy: false, 
						failUnstable: false, 
						maxNumberOfBuilds: 0, 
						onlyStable: false, 
						sourceEncoding: 'ASCII', 
						zoomCoverageChart: false
				])
			}
		}
		
		stage('SonarQube analysis') { 
        	withSonarQubeEnv('sonarqube') { 
	          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.4.0.905:sonar ' + 
	          '-f all/pom.xml ' +
	          '-Dsonar.projectKey=com.huettermann:all:master ' +
	          '-Dsonar.language=java ' +
	          '-Dsonar.sources=. ' +
	          '-Dsonar.tests=. ' +
	          '-Dsonar.test.inclusions=**/*Test*/** ' +
	          '-Dsonar.exclusions=**/*Test*/**'
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

