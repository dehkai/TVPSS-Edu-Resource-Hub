package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.service.ResourceRequestService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        model.addAttribute("message", "Request submitted successfully!");
        return "resource-request-submit-successful";
    }



    @GetMapping("/manage")
    public String showManageRequestsPage(Model model) {
        model.addAttribute("requests", resourceRequestService.getAllRequests());
        model.addAttribute("pendingRequests", resourceRequestService.findByStatus("pending"));
        model.addAttribute("approvedRequests", resourceRequestService.findByStatus("approved"));
        model.addAttribute("rejectedRequests", resourceRequestService.findByStatus("rejected"));
        
        return "manage-resource-request-dashboard";
    }

    @PostMapping("/manage/{id}/approve")
    @ResponseBody
    public String approveRequest(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        int approvedQuantity = Integer.parseInt(payload.get("approvedQuantity").toString());
        String feedback = (String) payload.get("feedback");
        resourceRequestService.approveRequest(id, approvedQuantity, feedback);
        return "Request approved";
    }

    @PostMapping("/manage/{id}/reject")
    @ResponseBody
    public String rejectRequest(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        String feedback = (String) payload.get("feedback");
        resourceRequestService.rejectRequest(id, feedback);
        return "Request rejected";
    }
}

