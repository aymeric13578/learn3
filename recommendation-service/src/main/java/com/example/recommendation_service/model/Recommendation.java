package com.example.recommendation_service.model;

import com.example.course_service.model.Course;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.user_service.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recommendations")
@NoArgsConstructor
@AllArgsConstructor
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
    private String recommendationReason;
}
