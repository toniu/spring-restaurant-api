# Use the official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use the official OpenJDK runtime image for running the application
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/spring-restaurant-api-0.0.1-SNAPSHOT.jar /app/spring-restaurant-api.jar
ENTRYPOINT ["java", "-jar", "spring-restaurant-api.jar"]