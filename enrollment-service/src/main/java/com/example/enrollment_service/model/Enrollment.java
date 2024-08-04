package com.example.enrollment_service.model;

import java.time.LocalDateTime;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String courseId;
    private LocalDateTime enrollmentDate;

    private Integer progress;

    // Getters and Setters
}
