FROM openjdk:8-jdk-alpine
COPY target/cloudkart-0.0.1-SNAPSHOT.jar cloudkart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cloudkart-0.0.1-SNAPSHOT.jar"]