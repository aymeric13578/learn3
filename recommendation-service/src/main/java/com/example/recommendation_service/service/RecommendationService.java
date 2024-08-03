package com.example.recommendation_service.service;

//handle recommendation logic
@Service
public class RecommendationService {
    // Placeholder for machine learning model
    private final MLModel mlModel;

    // Constructor
    public RecommendationService(MLModel mlModel) {
        this.mlModel = mlModel;
    }

    // Method to get recommendations based on user preferences
    public List<Course> getRecommendations(User user) {
        // Placeholder for actual recommendation logic
        return mlModel.predict(user);
    }
}
