package com.charlie.JobApplication.review.impl;

import com.charlie.JobApplication.company.Company;
import com.charlie.JobApplication.company.CompanyService;
import com.charlie.JobApplication.review.Review;
import com.charlie.JobApplication.review.ReviewRepository;
import com.charlie.JobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepo;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviewsForCompany(Long companyId) {
        return reviewRepo.findAllByCompanyId(companyId);
    }

    @Override
    public boolean postReviewForCompany(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);

        if(company!= null){
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        return reviewRepo.findReviewByCompanyIdAndReviewId(companyId, reviewId).get();
    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, Review review) {
        Optional<Review> currentReview = reviewRepo.findReviewByCompanyIdAndReviewId(companyId, reviewId);

        if(currentReview.isPresent()){
            Review updatedReview = currentReview.get();
            updatedReview.setTitle(review.getTitle());
            updatedReview.setReviewDescription(review.getReviewDescription());
            updatedReview.setRating(review.getRating());

            reviewRepo.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        Optional<Review> review = reviewRepo.findReviewByCompanyIdAndReviewId(companyId, reviewId);

        if(review.isPresent()){
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }


}
