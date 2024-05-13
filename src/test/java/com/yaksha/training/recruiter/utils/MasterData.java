package com.yaksha.training.recruiter.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yaksha.training.recruiter.entity.Recruiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterData {

    private static Random rnd = new Random();

    public static Recruiter getRecruiter() {
        Recruiter recruiter = new Recruiter();
        recruiter.setId(1L);
        recruiter.setCompanyName(randomStringWithSize(10));
        recruiter.setSalary(10D);
        recruiter.setTotalRequirement(100);
        recruiter.setJobDescription(randomStringWithSize(10));
        recruiter.setJobDesignation(randomStringWithSize(10));
        recruiter.setLocation(randomStringWithSize(10));
        recruiter.setEligibility(randomStringWithSize(10));
        return recruiter;
    }

    public static List<Recruiter> getRecruiterList(int size) {
        Long id = 0L;
        List<Recruiter> recruiters = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Recruiter recruiter = new Recruiter();
            recruiter.setId(++id);
            recruiter.setCompanyName(randomStringWithSize(10));
            recruiter.setSalary(10D);
            recruiter.setTotalRequirement(100);
            recruiter.setRequiredExperience(5);
            recruiter.setJobDescription(randomStringWithSize(10));
            recruiter.setJobDesignation(randomStringWithSize(10));
            recruiter.setLocation(randomStringWithSize(10));
            recruiter.setEligibility(randomStringWithSize(10));
            recruiters.add(recruiter);
        }
        return recruiters;
    }


    public static String randomStringWithSize(int size) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + (String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length()))));
        }
        return s;
    }

    public static boolean randomBoolean() {
        String alphabet = "1234567890";
        Random rnd = new Random();
        return rnd.nextInt(alphabet.length()) % 2 == 0;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
