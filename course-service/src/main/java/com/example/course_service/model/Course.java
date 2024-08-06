package com.example.course_service.model;

import java.time.LocalDateTime;

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
