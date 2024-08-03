
### 4. **API Gateway Module**

```markdown
# API Gateway Module

## Overview

The API Gateway Module provides load balancing, rate limiting, and API versioning for all microservices.

## Features

- **Load Balancing**: Configured using the `lb://` URI scheme.
- **Rate Limiting**: Implemented with RequestRateLimiter filters.
- **API Versioning**: Handles multiple API versions with different routes.

## Usage

1. **Add Dependency**: Add the `api-gateway` module dependency to your microservices.

2. **Configure Routes**: Define routes for different API versions and services.

   ```properties
   spring.cloud.gateway.routes[0].id=service-id
   spring.cloud.gateway.routes[0].uri=lb://service-name
