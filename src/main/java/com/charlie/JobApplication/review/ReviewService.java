package com.charlie.JobApplication.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsForCompany(Long companyId);

    void postReviewForCompany(Long companyId, Review review);

    public Review getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId);
}
