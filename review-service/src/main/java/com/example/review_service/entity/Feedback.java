package com.example.review_service.entity;

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
