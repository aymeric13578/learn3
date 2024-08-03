package com.example.recommendation_service.controller;


@RestController
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations/{userId}")
    public List<Course> getRecommendations(@PathVariable String userId) {
        User user = getUserById(userId); // Retrieve user information
        return recommendationService.getRecommendations(user);
    }
}
