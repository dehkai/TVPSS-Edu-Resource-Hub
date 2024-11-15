package com.codecrafters.tvpss.controller;
import com.codecrafters.tvpss.model.CandidateApplicationModel;
import com.codecrafters.tvpss.service.CandidateApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CandidateApplicationController {

    @Autowired
    private CandidateApplicationService candidateApplicationService;

    @GetMapping("/candidate-request")
    public String showForm(Model model) {
        model.addAttribute("candidateRequest", new CandidateApplicationModel());
        return "candidate-application-list";
    }

    @GetMapping("/candidate-profile")
    public String showCandidateProfile(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        return "candidate-application-profile";
    }

    @PostMapping("/submitCandidateRequest")
    public String submitForm(CandidateApplicationModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "interview-form";
    }

}
