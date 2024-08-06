package com.example.course_service.model;

@Entity
public class CourseContent {
    @Id
    private UUID contentId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String contentType;
    private String contentData;
}
