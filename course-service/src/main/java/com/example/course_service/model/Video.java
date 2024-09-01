package com.example.course_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@AllArgsConstructor
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

    private LocalDateTime lastWatched;
    private Integer watchedDuration;
}
