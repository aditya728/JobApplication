package com.charlie.JobApplication.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
Endpoints for Review Feature

GET    /company/{companyId}/reviews
POST   /company/{companyId}/reviews
GET    /company/{companyId}/reviews/{reviewId}
PUT    /company/{companyId}/reviews/{reviewId}
DELETE /company/{companyId}/reviews/{reviewId}
*/

@RestController
@RequestMapping("/company/{companyId}/reviews")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsForCompany(@PathVariable Long companyId){
        List<Review> reviews = reviewService.getAllReviewsForCompany(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postReviewForCompany(@PathVariable Long companyId, @RequestBody Review review){
        reviewService.postReviewForCompany(companyId, review);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);

        if(review != null){
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
