package com.yaksha.training.recruiter.boundary;


import com.yaksha.training.recruiter.entity.Recruiter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.yaksha.training.recruiter.utils.MasterData.getRecruiter;
import static com.yaksha.training.recruiter.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.recruiter.utils.TestUtils.boundaryTestFile;
import static com.yaksha.training.recruiter.utils.TestUtils.currentTest;
import static com.yaksha.training.recruiter.utils.TestUtils.testReport;
import static com.yaksha.training.recruiter.utils.TestUtils.yakshaAssert;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testCompanyNameNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setCompanyName(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyNameNotBlank() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setCompanyName("");
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyNameMinThree() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setCompanyName(randomStringWithSize(2));
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanyNameMaxTwenty() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setCompanyName(randomStringWithSize(21));
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCompanySalaryNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setSalary(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testJobDesignationNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDesignation(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testJobDesignationNotBlank() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDesignation("");
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testJobDescriptionNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDescription(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testJobDescriptionNotBlank() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDescription("");
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLocationNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setLocation(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLocationNotBlank() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setLocation("");
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testEligibilityNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setEligibility(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testEligibilityNotBlank() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setEligibility("");
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testTotalRequirementNotNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setTotalRequirement(null);
        Set<ConstraintViolation<Recruiter>> violations = validator.validate(recruiter);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

}
