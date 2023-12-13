package com.yaksha.training.recruiter.service;

import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.repository.RecruiterRepository;
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

    public List<Recruiter> searchRecruiters(String theSearchName) {
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            return recruiterRepository.findByRecruiterCompanyName(theSearchName);
        } else {
            return recruiterRepository.findAll();
        }
    }
}
