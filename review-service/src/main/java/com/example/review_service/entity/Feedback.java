package com.example.review_service.entity;

import com.example.course_service.model.Course;
import com.example.user_service.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "feedback")
@NoArgsConstructor
@AllArgsConstructor
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

    private Boolean resolved;
}
