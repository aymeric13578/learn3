package com.example.recommendation_service.model;

import java.time.LocalDateTime;

public class Recommendation {
    @Id
    private UUID recommendationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime recommendedOn;
}
