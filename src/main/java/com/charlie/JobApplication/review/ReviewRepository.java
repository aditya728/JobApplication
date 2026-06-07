package com.charlie.JobApplication.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>{

    List<Review> findAllByCompanyId(Long companyId);

    @Query(value = "select * from review where company_id = :companyId AND id = :reviewId", nativeQuery = true)
    Optional<Review> findReviewByCompanyIdAndReviewId(@Param("companyId")Long companyId, @Param("reviewId") Long reviewId);
}
