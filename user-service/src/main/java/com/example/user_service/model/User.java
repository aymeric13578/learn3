package com.example.user_service.model;

import com.example.course_service.model.Course;
import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.model.Waitlist;
import com.example.payment_service.model.Payment;
import com.example.recommendation_service.model.Recommendation;
import com.example.report_service.model.Analytics;
import com.example.review_service.entity.Feedback;
import com.example.review_service.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private UUID userId;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime lastActive;

    private String profileImageUrl;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;

    @OneToMany(mappedBy = "user")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "user")
    private Set<Waitlist> waitlist;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "user")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "user")
    private Set<Recommendation> recommendations;

    @OneToMany(mappedBy = "user")
    private Set<Analytics> analytics;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
