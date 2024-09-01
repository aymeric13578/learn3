package com.example.course_service.model;

import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.model.Waitlist;
import com.example.payment_service.model.Payment;
import com.example.recommendation_service.model.Recommendation;
import com.example.report_service.model.Analytics;
import com.example.review_service.entity.Feedback;
import com.example.review_service.entity.Review;
import com.example.user_service.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID courseId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private BigDecimal popularityScore;
    private String difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "course")
    private Set<Module> modules;

    @OneToMany(mappedBy = "course")
    private Set<CourseContent> courseContents;

    @OneToMany(mappedBy = "course")
    private Set<CourseMaterial> courseMaterials;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private Set<Waitlist> waitlist;

    @OneToMany(mappedBy = "course")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "course")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "course")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "course")
    private Set<Recommendation> recommendations;

    @OneToMany(mappedBy = "course")
    private Set<Analytics> analytics;
}
