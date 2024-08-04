# Dockerfile for report-service

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/report-service.jar /app/report-service.jar

# Expose the port the app runs on
EXPOSE 8088

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/report-service.jar"]
