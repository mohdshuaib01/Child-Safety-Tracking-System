# Step 1: Java 22 image ka use karke sirf classes compile karenge
FROM openjdk:22-jdk-slim AS builder
WORKDIR /app
COPY . .
# Java files ko compile karne ke liye directory setup
RUN mkdir -p build/classes
RUN find src/main/java -name "*.java" > sources.txt && \
    javac -d build/classes -sourcepath src/main/java @sources.txt

# Step 2: Tomcat par built files ko copy karenge
FROM tomcat:10.1-jdk17-openjdk-slim
COPY src/main/webapp/ /usr/local/tomcat/webapps/ROOT/
COPY --from=builder /app/build/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

EXPOSE 8080
CMD ["catalina.sh", "run"]