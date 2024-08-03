package com.example.course_service.model;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String content;
    private Date createdDate;

    //To maintain versions of course content, you might use a versioning table or additional fields in your model
    private Integer version;


    // Getters and Setters
}
