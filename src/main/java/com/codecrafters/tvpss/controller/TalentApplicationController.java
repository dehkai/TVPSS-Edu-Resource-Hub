package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.service.TalentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TalentApplicationController {


    @Autowired
    private TalentApplicationService applicationService;

    @GetMapping("/talent-form")
    public String showForm(Model model) {
        model.addAttribute("talentApplicationRequest", new TalentApplicationModel());
        return "/talent-application/update-talent-application-status";
    }

    @GetMapping("/talent-list")
    public String showTalentApplicationList(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        return "/talent-application/manage-talent-application";
    }

    @GetMapping("/talentPost-form")
    public String showTalentPostForm(Model model) {
        model.addAttribute("talentPostRequest", new TalentPostModel());
        return "/talent-application/update-talent-post";
    }

    @GetMapping("/talentPost-list")
    public String showTalentPostList(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        List<TalentPostModel> talentPostList = applicationService.getAllPostTalent();
        System.out.println("Talent Post List Size: " + talentPostList.size());  // Debug log
        model.addAttribute("talentPostList", talentPostList);
        return "/talent-application/manage-talent-post";
    }

    @PostMapping("/submitTalentRequest")
    public String submitForm(TalentApplicationModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "/talent-application/manage-talent-application";
    }

    @PostMapping("/submitTalentPostRequest")
    public String submitTalentPostForm(TalentPostModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "manage-talent-post";
    }


}
