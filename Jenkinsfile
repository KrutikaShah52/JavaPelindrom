pipeline {
	agent {
		node{
			label 'master'
		}
	}
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
      					execPattern: 'target/jacoco.exec',
      					classPattern: '**/classes',
      					sourcePattern: '**/src/main/java',
      					exclusionPattern: '**/test/**'
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
		stage('SonarQube Analysis'){
			steps {
				script {
					withSonarQubeEnv('sonarqube') {
						sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.4.0.905:sonar ' + 
						'-f pom.xml ' +
						'-Dsonar.login=$SONAR_UN ' +
						'-Dsonar.password=$SONAR_PW '
						'-Duser.home=/var/maven ' +
						'-Dsonar.sources=src/main ' +
						'-Dsonar.tests=src/test ' +
						'-Dsonar.java.binaries=target/classes '
						'-Dsonar.test.inclusions=**/*Test*/* ' +
						'-Dsonar.exclusions=**/*Test*/* '
						'-Dsonar.java.coveragePlugin=jacoco'
						'-Dsonar.jacoco.reportMissing.force.zero=true'
						'-Dsonar.jacoco.reportPaths=target/jacoco.exec'
						'-Dsonar.junit.reportsPaths=target/surefire-reports'
					}
				}
			}
		}
		// stage('SonarQube analysis') {
		// 	steps { 
		// 		withSonarQubeEnv('sonarqube') { 
		// 			  sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.4.0.905:sonar ' + 
		// 			  '-f pom.xml ' +
		// 			  '-Dsonar.login=$SONAR_UN ' +
		// 			  '-Dsonar.password=$SONAR_PW '
	    //     	        }
        // 		}
    	// }
	}
}
