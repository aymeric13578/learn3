package com.example.review_service.controller;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    @PutMapping("/{id}/moderate")
    public ResponseEntity<Void> moderateReview(@PathVariable Long id, @RequestParam boolean approve) {
        reviewService.moderateReview(id, approve);
        return ResponseEntity.noContent().build();
    }
}
