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
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID materialId;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private CourseContent content;

    private String materialType;
    private String materialData;
}
