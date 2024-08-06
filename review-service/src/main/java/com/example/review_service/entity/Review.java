package com.example.review_service.entity;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    private UUID reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String sentiment;
    private boolean isSpam;
    private boolean isApproved;


    // Getters and setters
}

