# member-service/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/MemberService-0.0.1-SNAPSHOT.jar .

EXPOSE 8084

CMD ["java", "-jar", "MemberService-0.0.1-SNAPSHOT.jar"]
