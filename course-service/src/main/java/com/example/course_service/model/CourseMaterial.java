package com.example.course_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class CourseMaterial {
    @Id
    private UUID materialId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String materialType;
    private String materialData;
}
