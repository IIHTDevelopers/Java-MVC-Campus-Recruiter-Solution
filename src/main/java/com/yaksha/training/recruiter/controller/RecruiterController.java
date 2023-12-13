package com.yaksha.training.recruiter.controller;

import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/recruiter", "/"})
public class RecruiterController {

    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping(value = {"/list", "/"})
    public String listRecruiters(Model model) {
        List<Recruiter> recruiters = recruiterService.getRecruiters();
        model.addAttribute("recruiters", recruiters);
        return "list-recruiters";
    }

    @GetMapping("/addRecruiterForm")
    public String showFormForAdd(Model model) {
        Recruiter recruiter = new Recruiter();
        model.addAttribute("recruiter", recruiter);
        return "add-recruiter-form";
    }

    @PostMapping("/saveRecruiter")
    public String saveRecruiter(@Valid @ModelAttribute("recruiter") Recruiter recruiter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (recruiter.getId() != null) {
                return "update-recruiter-form";
            }
            return "add-recruiter-form";
        } else {
            recruiterService.saveRecruiter(recruiter);
            return "redirect:/recruiter/list";
        }
    }

    @GetMapping("/updateRecruiterForm")
    public String showFormForUpdate(@RequestParam("recruiterId") Long id, Model model) {
        Recruiter recruiter = recruiterService.getRecruiter(id);
        model.addAttribute("recruiter", recruiter);
        return "update-recruiter-form";
    }

    @GetMapping("/delete")
    public String deleteRecruiter(@RequestParam("recruiterId") Long id) {
        recruiterService.deleteRecruiter(id);
        return "redirect:/recruiter/list";
    }

    @PostMapping("/search")
    public String searchRecruiters(@RequestParam("theSearchName") String theSearchName,
                                   Model theModel) {

        List<Recruiter> theRecruiters = recruiterService.searchRecruiters(theSearchName);
        theModel.addAttribute("recruiters", theRecruiters);
        return "list-recruiters";
    }
}
