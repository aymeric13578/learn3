package com.example.review_service.service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;
    @Autowired
    private SpamDetectionService spamDetectionService;

    public Review addReview(Review review) {
        review.setSentiment(sentimentAnalysisService.analyzeSentiment(review.getContent()));
        review.setSpam(spamDetectionService.isSpam(review.getContent()));
        return reviewRepository.save(review);
    }

    public void moderateReview(Long id, boolean approve) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        review.setApproved(approve);
        reviewRepository.save(review);
    }
}
