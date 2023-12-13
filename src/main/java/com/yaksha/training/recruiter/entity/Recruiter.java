package com.yaksha.training.recruiter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public Recruiter() {
    }

    public Recruiter(Long id, String companyName, Double salary, String jobDesignation, String jobDescription, String location, String eligibility, Integer totalRequirement) {
        this.id = id;
        this.companyName = companyName;
        this.salary = salary;
        this.jobDesignation = jobDesignation;
        this.jobDescription = jobDescription;
        this.location = location;
        this.eligibility = eligibility;
        this.totalRequirement = totalRequirement;
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
        return "Recruiter{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", jobDesignation='" + jobDesignation + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", location='" + location + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", totalRequirement='" + totalRequirement + '\'' +
                '}';
    }
}
