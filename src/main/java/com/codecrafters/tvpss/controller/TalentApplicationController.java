package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.service.TalentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TalentApplicationController {


    @Autowired
    private TalentApplicationService applicationService;

    @GetMapping("/talent-form")
    public String showForm(Model model) {
        model.addAttribute("talentApplicationRequest", new TalentApplicationModel());
        return "update-talent-application-status";
    }

    @GetMapping("/talent-list")
    public String showTalentApplicationList(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        return "manage-talent-application";
    }

    @PostMapping("/submitTalentRequest")
    public String submitForm(TalentApplicationModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "manage-talent-application";
    }

}
