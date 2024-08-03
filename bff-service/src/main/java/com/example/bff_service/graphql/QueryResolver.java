package com.example.bff_service.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
@Component
public class QueryResolver {
    @QueryMapping
    public String getGreeting() {
        return "Hello, world!";
    }

    // Add more query methods as needed
}
