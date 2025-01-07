package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.service.TalentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "/talent-application/create-talent-post";
    }

    @GetMapping("/talentPost-form/update/{id}")
    public String showUpdateTalentPostForm(Model model,@PathVariable String id,
                                RedirectAttributes redirectAttributes) {
        try {
            TalentPostModel talentPost = applicationService.findById(id);
            model.addAttribute("talentPost", talentPost);
//            applicationService.updatePost(id);
            redirectAttributes.addFlashAttribute("message", "Request rejected successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to reject request");
        }
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
        model.addAttribute("message", "Request submitted successfully!");
        return "/talent-application/manage-talent-application";
    }

    @PostMapping("/submitTalentPostRequest")
    public String submitTalentPostForm(TalentPostModel request, Model model) {
        // Process the request object as needed
        applicationService.addPost(request);
        model.addAttribute("message", "Request submitted successfully!");
        return "redirect:/talentPost-list";
    }

    @PostMapping("/submitEditTalentPost")
    public String submitEditTalentPostForm(TalentPostModel request, Model model) {
        // Process the request object as needed
        applicationService.updatePost(request);
        model.addAttribute("message", "Request submitted successfully!");
        return "redirect:/talentPost-list";
    }


}
