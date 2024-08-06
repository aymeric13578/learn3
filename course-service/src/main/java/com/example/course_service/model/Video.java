package com.example.course_service.model;

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
