package com.yaksha.training.recruiter.repository;

import com.yaksha.training.recruiter.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    @Query(value = "Select c from Recruiter c where lower(companyName) like %:keyword%")
    List<Recruiter> findByRecruiterCompanyName(@Param("keyword") String keyword);
}
