package com.example.enrollment_service.model;

import com.example.course_service.model.Course;
import com.example.user_service.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "waitlist")
@NoArgsConstructor
@AllArgsConstructor
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
