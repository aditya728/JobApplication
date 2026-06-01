package com.charlie.JobApplication.review.impl;

import com.charlie.JobApplication.company.Company;
import com.charlie.JobApplication.company.CompanyService;
import org.springframework.stereotype.Service;
import com.charlie.JobApplication.review.Review;
import com.charlie.JobApplication.review.ReviewRepository;
import com.charlie.JobApplication.review.ReviewService;

import java.util.List;

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
    public void postReviewForCompany(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);

        if(company!= null){
            review.setCompany(company);
            reviewRepo.save(review);
        }
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        Review review;
        if(companyService.findCompanyById(companyId) != null){
            review = reviewRepo.findReviewById(companyId, reviewId);
            return review;
        }
        return null;
    }
}
