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
        boolean reviewPosted = reviewService.postReviewForCompany(companyId, review);
        if(reviewPosted)
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Review not added", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);

        if(review != null){
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,
                                    @PathVariable Long reviewId,
                                    @RequestBody Review review){
        boolean reviewUpdated = reviewService.updateReviewById(companyId, reviewId, review);

        if(reviewUpdated){
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Or Company Not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId){
        boolean reviewDeleted = reviewService.deleteReviewById(companyId, reviewId);

        if(reviewDeleted){
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Or Company Not found", HttpStatus.NOT_FOUND);
    }
}
