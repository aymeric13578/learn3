# Dockerfile for enrollment-service

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/enrollment-service.jar /app/enrollment-service.jar

# Expose the port the app runs on
EXPOSE 8086

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/enrollment-service.jar"]
