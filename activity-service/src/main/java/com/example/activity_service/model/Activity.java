package com.example.activity_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "activities")
public class Activity {

    @Id
    private String id;
    private String userId;
    private String activityType;
    private String details;
    private LocalDateTime timestamp;

    // Getters and setters
}
