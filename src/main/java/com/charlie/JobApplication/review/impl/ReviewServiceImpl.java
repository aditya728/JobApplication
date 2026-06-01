package com.charlie.JobApplication.review.impl;

import org.springframework.stereotype.Service;
import com.charlie.JobApplication.review.Review;
import com.charlie.JobApplication.review.ReviewRepository;
import com.charlie.JobApplication.review.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepo;

    public ReviewServiceImpl(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> getAllReviewsForCompany(Long companyId) {
        return reviewRepo.findAllReviewByCompanyId(companyId);
    }
}
