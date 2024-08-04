package com.example.review_service.entity;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String sentiment;
    private boolean isSpam;
    private boolean isApproved;

    private String userId;
    private String courseId;

    private Integer rating;

    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}

