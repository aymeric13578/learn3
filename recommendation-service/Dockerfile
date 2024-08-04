# Dockerfile for recommendation-service

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/recommendation-service.jar /app/recommendation-service.jar

# Expose the port the app runs on
EXPOSE 8085

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/recommendation-service.jar"]
