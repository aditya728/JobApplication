package com.charlie.JobApplication.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Query(value = "select * from review where company_id= :companyId", nativeQuery = true)
    List<Review> findAllReviewByCompanyId(@Param("companyId") Long companyId);
}
