FROM maven:3.8.5-openjdk-17 AS build
COPY pom.xml .
COPY /src /src
RUN mvn clean package

FROM openjdk:21-jdk-slim
COPY --from=build /target/*.jar application.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "application.jar"]