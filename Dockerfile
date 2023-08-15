# Dockerfile
FROM openjdk:17-oracle

WORKDIR /app

COPY target/local-oracle-database-connection-1.0-SNAPSHOT.jar .

CMD ["java", "-jar", "local-oracle-database-connection-1.0-SNAPSHOT.jar"]