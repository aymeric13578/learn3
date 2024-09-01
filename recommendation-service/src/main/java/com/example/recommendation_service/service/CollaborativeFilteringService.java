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
public class CollaborativeFilteringService {

    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public CollaborativeFilteringService(UserRepository userRepository, EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public List<UUID> getCollaborativeRecommendations(UUID userId) {
        // Fetch the user and their enrolled courses
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<UUID> userEnrolledCourseIds = getUserEnrolledCourseIds(userId);

        // Get all users and their enrolled courses
        List<User> allUsers = userRepository.findAll();
        Map<UUID, List<UUID>> userCourseMap = allUsers.stream()
                .collect(Collectors.toMap(User::getUserId, this::getUserEnrolledCourseIds));

        // Find similar users based on overlapping course enrollments
        Map<UUID, Integer> similarityScores = new HashMap<>();
        for (Map.Entry<UUID, List<UUID>> entry : userCourseMap.entrySet()) {
            if (!entry.getKey().equals(userId)) {
                int commonCourses = getCommonCourses(userEnrolledCourseIds, entry.getValue());
                similarityScores.put(entry.getKey(), commonCourses);
            }
        }

        // Sort users by similarity scores and fetch recommended courses
        List<UUID> similarUsers = similarityScores.entrySet().stream()
                .sorted(Map.Entry.<UUID, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Set<UUID> recommendedCourses = new HashSet<>();
        for (UUID similarUserId : similarUsers) {
            List<UUID> similarUserCourses = userCourseMap.get(similarUserId);
            recommendedCourses.addAll(similarUserCourses);
        }

        // Remove courses that the user is already enrolled in
        recommendedCourses.removeAll(userEnrolledCourseIds);

        // Convert to list and return
        return new ArrayList<>(recommendedCourses);
    }

    private List<UUID> getUserEnrolledCourseIds(UUID userId) {
        // Fetch enrolled course IDs
        return enrollmentRepository.findByUserId(userId).stream()
                .map(enrollment -> enrollment.getCourse().getCourseId())
                .collect(Collectors.toList());
    }

    private int getCommonCourses(List<UUID> userCourses, List<UUID> otherUserCourses) {
        Set<UUID> userCourseSet = new HashSet<>(userCourses);
        return (int) otherUserCourses.stream()
                .filter(userCourseSet::contains)
                .count();
    }
}
