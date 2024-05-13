package com.yaksha.training.recruiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import com.yaksha.training.recruiter.entity.Recruiter;
import com.yaksha.training.recruiter.service.RecruiterService;

import jakarta.validation.Valid;

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
    
    
    @GetMapping(value = {"/list", "/", "/search"})
    public String listDonors(@RequestParam(value = "theSearchName", required = false) String theSearchName,
                             @PageableDefault(size = 5) Pageable pageable, Model theModel) {
        Page<Recruiter> recruiters = recruiterService.searchRecruiters(theSearchName,pageable);
        theModel.addAttribute("recruiters", recruiters.getContent());
        theModel.addAttribute("theSearchName", theSearchName != null ? theSearchName : "");
        theModel.addAttribute("totalPage", recruiters.getTotalPages());
        theModel.addAttribute("page", pageable.getPageNumber());
        theModel.addAttribute("sortBy", pageable.getSort().get().count() != 0 ?
                pageable.getSort().get().findFirst().get().getProperty() + "," + pageable.getSort().get().findFirst().get().getDirection() : "");

        return "list-recruiters";
    }

//    @GetMapping(value = {"/list", "/"})
//    public String listRecruiters(Model model) {
//        List<Recruiter> recruiters = recruiterService.getRecruiters();
//        model.addAttribute("recruiters", recruiters);
//        return "list-recruiters";
//    }

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

//    @PostMapping("/search")
//    public String searchRecruiters(@RequestParam("theSearchName") String theSearchName,
//                                   Model theModel) {
//
//        List<Recruiter> theRecruiters = recruiterService.searchRecruiters(theSearchName,);
//        theModel.addAttribute("recruiters", theRecruiters);
//        return "list-recruiters";
//    }
}
