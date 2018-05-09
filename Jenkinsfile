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
		
		stage('SonarQube Build'){
			steps{
				withSonarQubeEnv('My SonarQube Server') {
      				sh 'mvn clean package sonar:sonar'
    			}
    		} 
		}
		
		stage("Quality Gate") {
			steps{
  				timeout(time: 1, unit: 'HOURS') { 
    				def qg = waitForQualityGate() 
   					if (qg.status != 'OK') {
      					error "Pipeline aborted due to quality gate failure: ${qg.status}"
    				}
  				}
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

