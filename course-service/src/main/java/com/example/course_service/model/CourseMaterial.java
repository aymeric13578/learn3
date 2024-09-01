package com.example.course_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "course_material")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID materialId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String materialType;
    private String materialData;
}
