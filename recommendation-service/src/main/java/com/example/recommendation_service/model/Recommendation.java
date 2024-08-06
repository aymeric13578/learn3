package com.example.recommendation_service.model;

import com.example.course_service.model.Course;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.user_service.model.User;

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
