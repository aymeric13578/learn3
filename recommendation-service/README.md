# Recommendation Microservice

## Overview

The Recommendation Microservice is designed to provide personalized course recommendations using two main algorithms:

1. **Collaborative Filtering**: Recommends courses based on the behavior of similar users.
2. **Content-Based Filtering**: Recommends courses based on user preferences and course content.

This service is built using Spring Boot and interacts with MongoDB for data storage.

## Project Structure

The project is organized into the following packages:

- `com.example.recommendation.controller`: Contains REST controllers.
- `com.example.recommendation.service`: Contains business logic for recommendation algorithms.
- `com.example.recommendation.repository`: Contains repositories for database interactions.
- `com.example.recommendation.model`: Contains data models for `User` and `Course`.
- `com.example.recommendation.config`: Contains configuration files.

## Setup Instructions

### Prerequisites

- Java 11 or higher
- Maven
- MongoDB

### Clone the Repository

```bash
git clone https://github.com/your-repo/recommendation-microservice.git
cd recommendation-microservice
