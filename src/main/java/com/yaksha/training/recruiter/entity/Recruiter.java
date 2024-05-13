package com.yaksha.training.recruiter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String companyName;

    @NotNull
    private Double salary;

    @NotBlank
    private String jobDesignation;

    @NotBlank
    private String jobDescription;

    @NotBlank
    private String location;

    @NotBlank
    private String eligibility;

    @NotNull
    private Integer totalRequirement;
    
    @NotNull
//    @Size(min = 1, max = 40, message = "Year should be between 1 to 99")
    @Min(value = 0, message = "Invalid Experience ")
    @Max(value = 99, message = "Experience cannot exceed 99 years")
    private Integer requiredExperience;

    public Integer getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(Integer requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public Recruiter() {
    }

    public Recruiter(Long id, String companyName, Double salary, String jobDesignation, String jobDescription, String location, String eligibility, Integer totalRequirement,Integer requiredExperience) {
        this.id = id;
        this.companyName = companyName;
        this.salary = salary;
        this.jobDesignation = jobDesignation;
        this.jobDescription = jobDescription;
        this.location = location;
        this.eligibility = eligibility;
        this.totalRequirement = totalRequirement;
        this.requiredExperience=requiredExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobDesignation() {
        return jobDesignation;
    }

    public void setJobDesignation(String jobDesignation) {
        this.jobDesignation = jobDesignation;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public Integer getTotalRequirement() {
        return totalRequirement;
    }

    public void setTotalRequirement(Integer totalRequirement) {
        this.totalRequirement = totalRequirement;
    }

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", companyName=" + companyName + ", salary=" + salary + ", jobDesignation="
				+ jobDesignation + ", jobDescription=" + jobDescription + ", location=" + location + ", eligibility="
				+ eligibility + ", totalRequirement=" + totalRequirement + ", requiredExperience=" + requiredExperience
				+ "]";
	}


}
