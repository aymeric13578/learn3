package com.example.course_service.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class Module {

    @Id
    private UUID moduleId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String title;
    private String content;
    private int order;
}
