# gateway-service/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/GatewayService-0.0.1-SNAPSHOT.jar .

EXPOSE 9000

CMD ["java", "-jar", "GatewayService-0.0.1-SNAPSHOT.jar"]
