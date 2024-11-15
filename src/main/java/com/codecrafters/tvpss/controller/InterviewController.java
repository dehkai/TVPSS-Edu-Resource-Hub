package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.InterviewModel;
import com.codecrafters.tvpss.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterviewController {


    @Autowired
    private InterviewService interviewService;

    @GetMapping("/interview-request")
    public String showForm(Model model) {
        model.addAttribute("interviewRequest", new InterviewModel());
        return "interview-form";
    }

    @GetMapping("/interview-list")
    public String showInterviewList(Model model) {
//        model.addAttribute("interviewRequest", new InterviewModel());
        return "interview-list";
    }

    @PostMapping("/submitInterviewRequest")
    public String submitForm(InterviewModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "interview-form";
    }
//
//
//
//    @GetMapping("/manage")
//    public String showManageRequestsPage(Model model) {
//        model.addAttribute("requests", InterviewService.getPendingRequests());
//        return "manage-resource-request-dashboard";
//    }
//
//    @PostMapping("/manage/{id}/approve")  // Updated path
//    @ResponseBody
//    public String approveRequest(@PathVariable Long id) {
//        InterviewService.approveRequest(id);
//        return "Request approved";
//    }
//
//    @PostMapping("/manage/{id}/reject")  // Updated path
//    @ResponseBody
//    public String rejectRequest(@PathVariable Long id) {
//        InterviewService.rejectRequest(id);
//        return "Request rejected";
//    }

}
