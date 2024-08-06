package com.example.course_service.model;

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
