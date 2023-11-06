FROM openjdk:17-jdk-slim AS build

MAINTAINER team3
COPY target/employee-management-system-0.0.1-SNAPSHOT.jar employee-management-system-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/employee-management-system-0.0.1-SNAPSHOT.jar"]