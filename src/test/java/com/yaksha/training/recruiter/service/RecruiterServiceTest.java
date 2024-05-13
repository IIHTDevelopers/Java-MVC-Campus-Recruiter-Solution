package com.yaksha.training.recruiter.service;

import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.repository.RecruiterRepository;
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

import java.util.List;
import java.util.Optional;

import static com.yaksha.training.recruiter.utils.MasterData.asJsonString;
import static com.yaksha.training.recruiter.utils.MasterData.getRecruiter;
import static com.yaksha.training.recruiter.utils.MasterData.getRecruiterList;
import static com.yaksha.training.recruiter.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.recruiter.utils.TestUtils.businessTestFile;
import static com.yaksha.training.recruiter.utils.TestUtils.currentTest;
import static com.yaksha.training.recruiter.utils.TestUtils.testReport;
import static com.yaksha.training.recruiter.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

public class RecruiterServiceTest {

    @Mock
    private RecruiterRepository recruiterRepository;

    @InjectMocks
    private RecruiterService recruiterService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testServiceGetRecruiters() throws Exception {
        List<Recruiter> actual = getRecruiterList(5);
        when(recruiterRepository.findAll()).thenReturn(actual);
        List<Recruiter> expected = recruiterService.getRecruiters();
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceSaveRecruiter() throws Exception {
        Recruiter actual = getRecruiter();
        when(recruiterRepository.save(actual)).thenReturn(actual);
        Recruiter expected = recruiterService.saveRecruiter(actual);
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceGetRecruiter() throws Exception {
        Recruiter actual = getRecruiter();
        when(recruiterRepository.findById(actual.getId())).thenReturn(Optional.of(actual));
        Recruiter expected = recruiterService.getRecruiter(actual.getId());
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceDeleteRecruiter() throws Exception {
        Recruiter actual = getRecruiter();
        boolean expected = recruiterService.deleteRecruiter(actual.getId());
        yakshaAssert(currentTest(),
                (expected ? true : false),
                businessTestFile);
    }
}
