FROM openjdk:11-jre-slim

COPY app.jar /app.jar

CMD ["java", "-jar", "app.jar"]
