# config-service/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/ConfigService-0.0.1-SNAPSHOT.jar .

EXPOSE 8888

CMD ["java", "-jar", "ConfigService-0.0.1-SNAPSHOT.jar"]
