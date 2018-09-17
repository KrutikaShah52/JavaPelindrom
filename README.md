# Java + Mvn + Jacoco + Cobertura + Junit + SonarQube-

Java project to generate SonarQube report

Add plugin into the pom.xml

localhost://9000 the sonarqube run on

report will be generate 

jenkins plugin where the Item job directly connect with the sonarqube's localhost

Its generate Report fot code-coverage 

Next step if you want to make docker image of this project.

put your Dockerfile in src/main/docker folder

go to the project folder where your pom.xml is exist.

Open terminal and write the command:

mvn clean install docker:build
