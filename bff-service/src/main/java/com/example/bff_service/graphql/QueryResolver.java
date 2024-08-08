package com.example.bff_service.graphql;

import com.example.bff_service.service.UserProfileService;
import com.example.course_service.model.Course;
import com.example.enrollment_service.model.Enrollment;
import com.example.payment_service.model.Payment;
import com.example.recommendation_service.model.Recommendation;
import com.example.report_service.model.Report;
import com.example.review_service.entity.Feedback;
import com.example.review_service.entity.Review;
import com.example.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class QueryResolver {

    @Autowired
    private UserProfileService userProfileService;

    public User user(String id) {
        return userProfileService.getUser(id);
    }

    public Course course(String id) {
        return userProfileService.getCourse(id);
    }

    public List<Enrollment> enrollments(String userId) {
        return userProfileService.getEnrollments(userId);
    }

    public List<Review> reviews(String courseId) {
        return userProfileService.getReviews(courseId);
    }

    public List<Recommendation> recommendations(String userId) {
        return userProfileService.getRecommendations(userId);
    }

    public List<Feedback> feedbacks(String courseId) {
        return userProfileService.getFeedbacks(courseId);
    }

    public List<Payment> payments(String userId) {
        return userProfileService.getPayments(userId);
    }

    public List<Report> analytics(String courseId) {
        return userProfileService.getAnalytics(courseId);
    }
}
