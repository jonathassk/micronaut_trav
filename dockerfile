# Imagem base Java 21
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/java-travel-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]