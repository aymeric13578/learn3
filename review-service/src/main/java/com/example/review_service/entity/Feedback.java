package com.example.review_service.entity;

import com.example.course_service.model.Course;
import com.example.user_service.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class Feedback {
    @Id
    private UUID feedbackId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String feedbackType;
    private String feedbackData;
}
