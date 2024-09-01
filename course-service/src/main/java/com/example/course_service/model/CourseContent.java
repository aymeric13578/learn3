package com.example.course_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "course_content")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CourseContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contentId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    private String contentType;
    private String contentData;


    @OneToMany(mappedBy = "courseContent")
    private Set<Video> videos;
}
