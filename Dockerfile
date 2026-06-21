# Tomcat server ka use karenge
FROM tomcat:10.1-jdk17-openjdk-slim

# Aapke project ke webapp folder ka saara data Tomcat ke ROOT folder mein copy karenge
COPY src/main/webapp/ /usr/local/tomcat/webapps/ROOT/

# Java classes jo compile hoti hain unhe sahi jagah bhejenge
COPY build/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

EXPOSE 8080
CMD ["catalina.sh", "run"]