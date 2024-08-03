package com.example.bff_service.graphql;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
@Component
public class MutationResolver {

    @MutationMapping
    public String createGreeting(String message) {
        return "Greeting created: " + message;
    }

    // Add more mutation methods as needed
}
