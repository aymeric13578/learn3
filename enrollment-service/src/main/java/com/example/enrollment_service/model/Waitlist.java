package com.example.enrollment_service.model;

@Entity
public class Waitlist {
    @Id
    private UUID waitlistId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime addedDate;
}
