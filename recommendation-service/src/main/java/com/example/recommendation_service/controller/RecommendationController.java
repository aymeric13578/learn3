package com.example.recommendation_service.controller;

import com.example.recommendation_service.service.CollaborativeFilteringService;
import com.example.recommendation_service.service.ContentBasedFilteringService;
import com.example.recommendation_service.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final ContentBasedFilteringService contentBasedFilteringService;
    private final CollaborativeFilteringService collaborativeFilteringService;


    public RecommendationController(ContentBasedFilteringService contentBasedFilteringService,
                                    CollaborativeFilteringService collaborativeFilteringService) {
        this.contentBasedFilteringService = contentBasedFilteringService;
        this.collaborativeFilteringService = collaborativeFilteringService;
    }

    @GetMapping("/content-based/{userId}")
    public ResponseEntity<List<UUID>> getContentBasedRecommendations(@PathVariable UUID userId) {
        List<UUID> recommendations = contentBasedFilteringService.getContentBasedRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/collaborative/{userId}")
    public ResponseEntity<List<UUID>> getCollaborativeRecommendations(@PathVariable UUID userId) {
        List<UUID> recommendations = collaborativeFilteringService.getCollaborativeRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }
}

