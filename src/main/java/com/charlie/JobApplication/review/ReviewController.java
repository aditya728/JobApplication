package com.charlie.JobApplication.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
