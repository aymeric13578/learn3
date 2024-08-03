# Report Service

## Overview

The Report Service is responsible for generating various types of reports related to the e-learning platform. This includes reports on user activities, course enrollments, payments, reviews, and more.

## Features

- **User Reports**: Generate reports about user activity, user growth, etc.
- **Course Reports**: Generate reports on course enrollments, completion rates, etc.
- **Payment Reports**: Generate financial reports, payment success rates, etc.
- **Enrollment Reports**: Generate reports on enrollment trends, waitlists, etc.
- **Review Reports**: Generate reports on review sentiments, frequency, etc.

## Technologies Used

- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Data JPA
- Spring Kafka
- OpenAPI 3.0
- MySQL

## Running the Application

1. Ensure that the service registry (Eureka server) is running.
2. Start the Report Service:

    ```sh
    ./mvnw spring-boot:run
    ```

## API Endpoints

- `GET /reports`: List all reports
- `POST /reports`: Create a new report
- `GET /reports/{reportId}`: Get a report by ID
- `DELETE /reports/{reportId}`: Delete a report by ID

## Configuration

Configuration details can be found in the `application.yml` file. Ensure that the database connection details are correct.

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/reports_db
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL5Dialect
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
