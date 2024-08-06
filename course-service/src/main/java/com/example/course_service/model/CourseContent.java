package com.example.course_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

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
