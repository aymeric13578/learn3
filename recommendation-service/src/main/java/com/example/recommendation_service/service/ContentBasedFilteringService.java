package com.example.recommendation_service.service;

import com.example.course_service.model.Course;
import com.example.course_service.repository.CourseRepository;
import com.example.enrollment_service.model.Enrollment;
import com.example.enrollment_service.repository.EnrollmentRepository;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContentBasedFilteringService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public ContentBasedFilteringService(UserRepository userRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<UUID> getContentBasedRecommendations(UUID userId) {
        // Fetch user preferences (e.g., preferred categories)
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<UUID> preferredCategoryIds = getUserPreferredCategoryIds(user);

        // Fetch all courses and filter based on user preferences
        List<Course> allCourses = courseRepository.findAll();
        List<Course> recommendedCourses = allCourses.stream()
                .filter(course -> preferredCategoryIds.contains(course.getCategory().getCategoryId()))
                .collect(Collectors.toList());

        // Remove courses that the user is already enrolled in
        List<UUID> userEnrolledCourseIds = getUserEnrolledCourseIds(userId);
        recommendedCourses = recommendedCourses.stream()
                .filter(course -> !userEnrolledCourseIds.contains(course.getCourseId()))
                .collect(Collectors.toList());

        // Convert to list of course IDs
        return recommendedCourses.stream()
                .map(Course::getCourseId)
                .collect(Collectors.toList());
    }

    private List<UUID> getUserPreferredCategoryIds(User user) {
        // Fetch user preferences based on user reviews
        return user.getReviews().stream()
                .map(review -> review.getCourse().getCategory().getCategoryId())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<UUID> getUserEnrolledCourseIds(UUID userId) {
        // Fetch enrolled course IDs
        return enrollmentRepository.findByUserId(userId).stream()
                .map(enrollment -> enrollment.getCourse().getCourseId())
                .collect(Collectors.toList());
    }
}
