package com.yaksha.training.recruiter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yaksha.training.recruiter.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

	@Query(value = "Select c from Recruiter c where :keyword is NULL or lower(companyName) like %:keyword% or cast(requiredExperience as string) like %:keyword% ")
	Page<Recruiter> findByRecruiterCompanyNameAndRequiredExperience(@Param("keyword") String keyword,
			Pageable pageable);

}
