package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.model.UserProfileModel;
import com.codecrafters.tvpss.model.TalentPostCandidateModel;
import com.codecrafters.tvpss.model.InterviewModel;
import com.codecrafters.tvpss.service.TalentApplicationService;
import com.codecrafters.tvpss.service.UserProfileService;
import com.codecrafters.tvpss.service.InterviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TalentApplicationController {


    @Autowired
    private TalentApplicationService applicationService;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private InterviewService interviewService;

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

    @GetMapping("/talentPostCandidate-list")
    public String showTalentPosCandidateList(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        List<TalentPostCandidateModel> talentPostCandidateList = applicationService.getAllPostTalentCandidate();
        System.out.println("Talent Post List Size: " + talentPostCandidateList.size());  // Debug log
        model.addAttribute("talentPostCandidateList", talentPostCandidateList);
        return "/talent-application/manage-talent-post-candidate";
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

    @GetMapping("/dashboard/student/talent-post/view-all")
    public String showAllPostList(Model model) {
        List<TalentPostModel> talentPostList = applicationService.getAllPostTalent();
        System.out.println("Talent Post List Size: " + talentPostList.size());  // Debug log
        model.addAttribute("talentPostList", talentPostList);
//        model.addAttribute("interviewRequest", new InterviewModel());
        return "/talent-application/student-view-all-post-list";
    }

    @GetMapping("/dashboard/student/talent-post/apply/{id}")
    public String showPostList(Model model,@PathVariable String id) {
        TalentPostModel talentPost = applicationService.findById(id);
        System.out.println("TalentPost" + talentPost.getTalentName());
        model.addAttribute("talentPost", talentPost);
        return "/talent-application/student-apply-post-list";
    }

    @PostMapping("/submitAddPostCandidate")
    public String submitAddPostCandidateForm(HttpSession session, TalentPostModel request, Model model) {
        // Process the request object as needed
        String userName = (String) session.getAttribute("username");
        UserProfileModel userProfileModel = userProfileService.findByUsername(userName);
        long postIdLong = request.getId(); // Assuming getId() returns a long
        int postId = (int) postIdLong;
        InterviewModel interviewModel = new InterviewModel();
        int interview_id = interviewService.createInterview(interviewModel,postId, userName);

        applicationService.addPostCandidate(request,userProfileModel.getId(),interview_id);
        model.addAttribute("message", "Request submitted successfully!");
        return "redirect:/dashboard/student";
    }


}
