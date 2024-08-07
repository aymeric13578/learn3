package com.example.course_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID videoId;

    @ManyToOne
    @JoinColumn(name = "course_content_id")
    private CourseContent courseContent;

    private String videoUrl;
    private int duration;
}
