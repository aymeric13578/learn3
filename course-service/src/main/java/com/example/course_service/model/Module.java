package com.example.course_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "modules")
@NoArgsConstructor
@AllArgsConstructor
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
