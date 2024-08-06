package com.example.course_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ContentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID versionId;

    private UUID contentId;
    private String contentData;
    private LocalDateTime createdAt;

    // Getters and setters
}

