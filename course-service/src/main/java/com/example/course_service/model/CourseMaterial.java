package com.example.course_service.model;

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
