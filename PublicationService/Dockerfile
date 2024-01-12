# publication-service/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/PublicationService-0.0.1-SNAPSHOT.jar .

EXPOSE 8999

CMD ["java", "-jar", "PublicationService-0.0.1-SNAPSHOT.jar"]
