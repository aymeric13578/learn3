package com.example.bff_service.service;

import com.example.bff_service.model.*;
import com.example.course_service.model.Course;
import com.example.enrollment_service.model.Enrollment;
import com.example.payment_service.model.Payment;
import com.example.recommendation_service.model.Recommendation;
import com.example.report_service.model.Report;
import com.example.report_service.service.ReportService;
import com.example.review_service.entity.Feedback;
import com.example.review_service.entity.Review;
import com.example.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserProfileService {

    @Value("${services.user-service}")
    private String userServiceUrl;

    @Value("${services.course-service}")
    private String courseServiceUrl;

    @Value("${services.enrollment-service}")
    private String enrollmentServiceUrl;

    @Value("${services.review-service}")
    private String reviewServiceUrl;

    @Value("${services.recommendation-service}")
    private String recommendationServiceUrl;

    @Value("${services.feedback-service}")
    private String feedbackServiceUrl;

    @Value("${services.payment-service}")
    private String paymentServiceUrl;

    @Value("${services.analytics-service}")
    private String analyticsServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "users", key = "#id")
    public User getUser(String id) {
        return restTemplate.getForObject(userServiceUrl + "/users/" + id, User.class);
    }

    @Cacheable(value = "courses", key = "#id")
    public Course getCourse(String id) {
        return restTemplate.getForObject(courseServiceUrl + "/courses/" + id, Course.class);
    }

    @Cacheable(value = "enrollments", key = "#userId")
    public List<Enrollment> getEnrollments(String userId) {
        Enrollment[] enrollments = restTemplate.getForObject(enrollmentServiceUrl + "/users/" + userId + "/enrollments", Enrollment[].class);
        return Arrays.asList(enrollments);
    }

    @Cacheable(value = "reviews", key = "#courseId")
    public List<Review> getReviews(String courseId) {
        Review[] reviews = restTemplate.getForObject(reviewServiceUrl + "/courses/" + courseId + "/reviews", Review[].class);
        return Arrays.asList(reviews);
    }

    @Cacheable(value = "recommendations", key = "#userId")
    public List<Recommendation> getRecommendations(String userId) {
        Recommendation[] recommendations = restTemplate.getForObject(recommendationServiceUrl + "/users/" + userId + "/recommendations", Recommendation[].class);
        return Arrays.asList(recommendations);
    }

    @Cacheable(value = "feedbacks", key = "#courseId")
    public List<Feedback> getFeedbacks(String courseId) {
        Feedback[] feedbacks = restTemplate.getForObject(feedbackServiceUrl + "/courses/" + courseId + "/feedbacks", Feedback[].class);
        return Arrays.asList(feedbacks);
    }

    @Cacheable(value = "payments", key = "#userId")
    public List<Payment> getPayments(String userId) {
        Payment[] payments = restTemplate.getForObject(paymentServiceUrl + "/users/" + userId + "/payments", Payment[].class);
        return Arrays.asList(payments);
    }

    @Cacheable(value = "reports", key = "#courseId")
    public List<Report> getAnalytics(String courseId) {
        Report[] analytics = restTemplate.getForObject(analyticsServiceUrl + "/courses/" + courseId + "/reports", Report[].class);
        return Arrays.asList(analytics);
    }

    public User createUser(CreateUserInput input) {
        return restTemplate.postForObject(userServiceUrl + "/users", input, User.class);
    }

    public User updateUser(String id, UpdateUserInput input) {
        restTemplate.put(userServiceUrl + "/users/" + id, input);
        return getUser(id);
    }

    public Course createCourse(CreateCourseInput input) {
        return restTemplate.postForObject(courseServiceUrl + "/courses", input, Course.class);
    }

    public Enrollment enrollUser(EnrollUserInput input) {
        return restTemplate.postForObject(enrollmentServiceUrl + "/enrollments", input, Enrollment.class);
    }

    public Review addReview(AddReviewInput input) {
        return restTemplate.postForObject(reviewServiceUrl + "/reviews", input, Review.class);
    }

    public Payment processPayment(ProcessPaymentInput input) {
        return restTemplate.postForObject(paymentServiceUrl + "/payments", input, Payment.class);
    }

    public Feedback addFeedback(AddFeedbackInput input) {
        return restTemplate.postForObject(feedbackServiceUrl + "/feedbacks", input, Feedback.class);
    }

    public Recommendation addRecommendation(AddRecommendationInput input) {
        return restTemplate.postForObject(recommendationServiceUrl + "/recommendations", input, Recommendation.class);
    }
}