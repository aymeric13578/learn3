package com.example.course_service.model;

import com.example.user_service.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Course {
    @Id
    private UUID courseId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
