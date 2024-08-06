package com.example.report_service.model;

@Entity
public class Analytics {
    @Id
    private UUID analyticsId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String activityType;
    private LocalDateTime timestamp;

    // Getters and Setters
}
