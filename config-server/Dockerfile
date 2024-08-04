# Dockerfile for config-server

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/config-server.jar /app/config-server.jar

# Expose the port the app runs on
EXPOSE 8888

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/config-server.jar"]
