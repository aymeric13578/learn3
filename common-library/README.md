# API Definitions Module

## Overview

The API Definitions Module provides centralized API specifications using OpenAPI. It ensures consistent API contracts across all microservices in the e-learning platform.

## Features

- **Centralized API Specifications**: Provides a single source of truth for API definitions.
- **Resource Management**: Stores `openapi.yml` for API contract.

## Usage

1. **Add Dependency**: Include `api-definitions` module as a dependency in your microservices.

2. **Access API Definitions**: Access API specifications via classpath or REST endpoint in your modules.

   ```java
   @Value("classpath:/openapi.yml")
   private Resource openApiResource;