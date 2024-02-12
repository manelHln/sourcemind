FROM maven:3.9.5-eclipse-temurin-17 as maven
LABEL COMPANY="employeem"
LABEL MAINTAINER="tiburce.sotohou@gmail.com"
LABEL APPLICATION="EmployeeM"

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn -DskipTests package

FROM openjdk:22-ea-17-jdk-slim
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/employeem.jar /opt/app/api.jar
ENTRYPOINT ["java", "-jar", "/opt/app/api.jar"]