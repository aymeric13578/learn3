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
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID moduleId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String title;
    private String content;
    private int order;
}
