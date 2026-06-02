package com.charlie.JobApplication.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsForCompany(Long companyId);

    boolean postReviewForCompany(Long companyId, Review review);

    Review getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId);

    boolean updateReviewById(Long companyId, Long reviewId, Review review);

    boolean deleteReviewById(Long companyId, Long reviewId);
}
