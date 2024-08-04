# Dockerfile for service-registry

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/service-registry.jar /app/service-registry.jar

# Expose the port the app runs on
EXPOSE 8761

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/service-registry.jar"]
