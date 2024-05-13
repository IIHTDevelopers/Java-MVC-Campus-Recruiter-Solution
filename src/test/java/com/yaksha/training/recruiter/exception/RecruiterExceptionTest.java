package com.yaksha.training.recruiter.exception;

import com.yaksha.training.recruiter.controller.RecruiterController;
import com.yaksha.training.recruiter.entity.Recruiter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import static com.yaksha.training.recruiter.utils.MasterData.getRecruiter;
import static com.yaksha.training.recruiter.utils.TestUtils.currentTest;
import static com.yaksha.training.recruiter.utils.TestUtils.exceptionTestFile;
import static com.yaksha.training.recruiter.utils.TestUtils.testReport;
import static com.yaksha.training.recruiter.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class RecruiterExceptionTest {

    @InjectMocks
    private RecruiterController recruiterController;

    private MockMvc mockMvc;

    BindingResult bindingResult = mock(BindingResult.class);

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(recruiterController).build();
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testExceptionSaveRecruiterCompanyNameAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setCompanyName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterSalaryAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setSalary(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterJobDesignationAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setJobDesignation(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterJobDescriptionAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setJobDescription(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterLocationAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setLocation(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterEligibilityAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setEligibility(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterTotalRequirementAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setTotalRequirement(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveRecruiterRequiredExperienceAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setRequiredExperience(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterCompanyNameAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setCompanyName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterSalaryAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setSalary(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterJobDesignationAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDesignation(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterJobDescriptionAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setJobDescription(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterLocationAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setLocation(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterEligibilityAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setEligibility(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRecruiterTotalRequirementAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setTotalRequirement(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateRequiredExperienceAsNull() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setRequiredExperience(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form")), exceptionTestFile);
    }


}