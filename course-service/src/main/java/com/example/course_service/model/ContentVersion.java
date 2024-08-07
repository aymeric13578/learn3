package com.example.course_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
public class ContentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID versionId;

    private UUID contentId;
    private String contentData;
    private LocalDateTime createdAt;

    // Getters and setters
}

