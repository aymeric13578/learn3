package com.example.recommendation_service.service;

import org.springframework.stereotype.Service;

import java.util.List;

//handle recommendation logic
@Service
public class RecommendationService {

    private final CollaborativeFilteringService collaborativeFilteringService;
    private final ContentBasedFilteringService contentBasedFilteringService;

    public RecommendationService(CollaborativeFilteringService collaborativeFilteringService,
                                 ContentBasedFilteringService contentBasedFilteringService) {
        this.collaborativeFilteringService = collaborativeFilteringService;
        this.contentBasedFilteringService = contentBasedFilteringService;
    }

    public List<String> getRecommendationsForUser(String userId) {
        List<String> collaborativeRecommendations = collaborativeFilteringService.getCollaborativeRecommendations(userId);
        List<String> contentBasedRecommendations = contentBasedFilteringService.getContentBasedRecommendations(userId);

        // Merge recommendations, ensuring no duplicates
        collaborativeRecommendations.addAll(contentBasedRecommendations);
        return collaborativeRecommendations;
    }
}
