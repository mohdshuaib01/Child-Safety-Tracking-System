
FROM tomcat:10.1-jdk22-openjdk-slim


COPY src/main/webapp/ /usr/local/tomcat/webapps/ROOT/


COPY build/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

EXPOSE 8080
CMD ["catalina.sh", "run"]