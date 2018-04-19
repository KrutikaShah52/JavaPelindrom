#Pull base Image
From tomcat:8-jre8 


#Change the user to root

USER root

#RUN mkdir /usr/local/tomcat/webapps

#Copy the war file to tomcat webapps

COPY *.war /usr/local/tomcat/webapps/

#restart tomcat

CMD ["catalina.sh", "run"]
