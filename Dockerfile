FROM openjdk:17-jdk-slim-buster

COPY optibot-webapp/optibot-webapp-app/target/optibot-webapp-app-1.0.0.jar /app/optibot-webapp-app.jar

EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "/app/optibot-webapp-app.jar"]