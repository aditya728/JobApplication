package com.charlie.JobApplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsForCompany(Long companyId);
}
