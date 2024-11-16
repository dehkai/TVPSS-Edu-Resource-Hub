package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService resourceRequestService;

    @GetMapping("/resource-request")
    public String showForm(Model model) {
        model.addAttribute("resourceRequest", new ResourceRequestModel());
        return "resource-request-form";
    }

    @PostMapping("/submitRequest")
    public String submitForm(ResourceRequestModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "resource-request-submit-successful";
    }



    @GetMapping("/manage")
    public String showManageRequestsPage(Model model) {
        model.addAttribute("requests", resourceRequestService.getPendingRequests());
        return "manage-resource-request-dashboard";
    }

    @PostMapping("/manage/{id}/approve")  // Updated path
    @ResponseBody
    public String approveRequest(@PathVariable String id) {
        resourceRequestService.approveRequest(id);
        return "Request approved";
    }

    @PostMapping("/manage/{id}/reject")  // Updated path
    @ResponseBody
    public String rejectRequest(@PathVariable String id) {
        resourceRequestService.rejectRequest(id);
        return "Request rejected";
    }
    }

