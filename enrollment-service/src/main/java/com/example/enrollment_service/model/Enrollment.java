package com.example.enrollment_service.model;

import java.time.LocalDateTime;

@Entity
public class Enrollment {
    @Id
    private UUID enrollmentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime enrollmentDate;
    private double progress;

    private String status;

    // Getters and Setters
}
