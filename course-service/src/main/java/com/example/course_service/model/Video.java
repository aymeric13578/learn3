package com.example.course_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class Video {
    @Id
    private UUID videoId;

    @ManyToOne
    @JoinColumn(name = "course_content_id")
    private CourseContent courseContent;

    private String videoUrl;
    private int duration;
}
