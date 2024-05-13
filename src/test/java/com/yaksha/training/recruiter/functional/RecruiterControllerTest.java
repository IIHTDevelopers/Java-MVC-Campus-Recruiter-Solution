package com.yaksha.training.recruiter.functional;
import com.yaksha.training.recruiter.controller.RecruiterController;
import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.service.RecruiterService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.yaksha.training.recruiter.utils.MasterData.asJsonString;
import static com.yaksha.training.recruiter.utils.MasterData.getRecruiter;
import static com.yaksha.training.recruiter.utils.MasterData.getRecruiterList;
import static com.yaksha.training.recruiter.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.recruiter.utils.TestUtils.businessTestFile;
import static com.yaksha.training.recruiter.utils.TestUtils.currentTest;
import static com.yaksha.training.recruiter.utils.TestUtils.testReport;
import static com.yaksha.training.recruiter.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class RecruiterControllerTest {

    @Mock
    private RecruiterService recruiterService;

    @InjectMocks
    private RecruiterController recruiterController;

    private MockMvc mockMvc;

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
    public void testControllerShowFormForAdd() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/addRecruiterForm")).andReturn();
        yakshaAssert(currentTest(), result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form"), businessTestFile);
    }

    @Test
    public void testControllerSaveRecruiterHasError() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setId(null);
        recruiter.setCompanyName(null);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-recruiter-form"), businessTestFile);
    }

    @Test
    public void testControllerUpdateRecruiterHasError() throws Exception {
        Recruiter recruiter = getRecruiter();
        recruiter.setSalary(null);
        MvcResult result = this.mockMvc.perform(post("/saveRecruiter")
                .flashAttr("recruiter", recruiter)).andReturn();
        yakshaAssert(currentTest(), result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form"), businessTestFile);
    }

    @Test
    public void testControllerShowFormForUpdate() throws Exception {
        Recruiter recruiter = getRecruiter();
        when(recruiterService.getRecruiter(recruiter.getId())).thenReturn(recruiter);
        MvcResult result = this.mockMvc.perform(get("/updateRecruiterForm")
                .param("recruiterId", recruiter.getId().toString())).andReturn();
        yakshaAssert(currentTest(), result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-recruiter-form"), businessTestFile);
    }

    @Test
    public void testControllerDeleteRecruiter() throws Exception {
        Recruiter recruiter = getRecruiter();
        MvcResult result = this.mockMvc.perform(get("/delete")
                .param("recruiterId", recruiter.getId().toString())).andReturn();
        yakshaAssert(currentTest(), result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("redirect:/recruiter/list"), businessTestFile);
    }
}
