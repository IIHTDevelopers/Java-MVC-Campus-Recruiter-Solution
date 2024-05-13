package com.yaksha.training.recruiter.service;

import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.repository.RecruiterRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public List<Recruiter> getRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return recruiters;
    }

    public Recruiter saveRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    public Recruiter getRecruiter(Long id) {
        return recruiterRepository.findById(id).get();
    }

    public boolean deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
        return true;
    }

    public Page<Recruiter> searchRecruiters(String theSearchName, Pageable pageable) {
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            return recruiterRepository.findByRecruiterCompanyNameAndRequiredExperience(theSearchName, pageable);
        } else {
            return recruiterRepository.findByRecruiterCompanyNameAndRequiredExperience(null, pageable);
        }
    }
}
