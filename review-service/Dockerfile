# Dockerfile for review-service

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/review-service.jar /app/review-service.jar

# Expose the port the app runs on
EXPOSE 8087

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/review-service.jar"]
