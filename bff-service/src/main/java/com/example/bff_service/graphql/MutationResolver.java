package com.example.bff_service.graphql;

import com.example.bff_service.model.*;
import com.example.bff_service.service.UserProfileService;
import com.example.course_service.model.Course;
import com.example.enrollment_service.model.Enrollment;
import com.example.payment_service.model.Payment;
import com.example.recommendation_service.model.Recommendation;
import com.example.review_service.entity.Feedback;
import com.example.review_service.entity.Review;
import com.example.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
@Component
public class MutationResolver  {

    @Autowired
    private UserProfileService userProfileService;

    public User createUser(CreateUserInput input) {
        return userProfileService.createUser(input);
    }

    public User updateUser(String id, UpdateUserInput input) {
        return userProfileService.updateUser(id, input);
    }

    public Course createCourse(CreateCourseInput input) {
        return userProfileService.createCourse(input);
    }

    public Enrollment enrollUser(EnrollUserInput input) {
        return userProfileService.enrollUser(input);
    }

    public Review addReview(AddReviewInput input) {
        return userProfileService.addReview(input);
    }

    public Payment processPayment(ProcessPaymentInput input) {
        return userProfileService.processPayment(input);
    }

    public Feedback addFeedback(AddFeedbackInput input) {
        return userProfileService.addFeedback(input);
    }

    public Recommendation addRecommendation(AddRecommendationInput input) {
        return userProfileService.addRecommendation(input);
    }
}
