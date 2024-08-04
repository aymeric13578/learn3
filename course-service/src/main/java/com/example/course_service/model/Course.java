package com.example.course_service.model;

import java.time.LocalDateTime;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String content;

    private LocalDateTime createdDate;

    private String instructorId;//UUID
    private Double price;
    private LocalDateTime updatedDate;

    //To maintain versions of course content, you might use a versioning table or additional fields in your model
    private Integer version;


    // Getters and Setters
}
