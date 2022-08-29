FROM openjdk:17-jdk-slim-buster

COPY fpsba-bot-webapp/fpsba-bot-webapp-app/target/fpsba-bot-webapp-app-1.0.0.jar /app/fpsba-bot-webapp-app.jar

EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "/app/fpsba-bot-webapp-app.jar"]