package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.service.ResourceRequestService;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService resourceRequestService;

    @GetMapping("/resource-request")
    public String showForm(Model model) {
        model.addAttribute("resourceRequest", new ResourceRequestModel());
        return "resource-request/resource-request-form";
    }

    @PostMapping("/submitRequest")
    public String submitForm(ResourceRequestModel request, RedirectAttributes redirectAttributes) {
        try {
            request.setStatus("pending"); // Set initial status
            request.setDateSubmitted(LocalDate.now()); // Set submission date
            resourceRequestService.addRequest(request);
            redirectAttributes.addFlashAttribute("success", "Request submitted successfully!");
            return "redirect:/resource-request/success";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to submit request: " + e.getMessage());
            return "redirect:/resource-request";
        }
    }

    @GetMapping("/resource-request/success")
    public String showSuccessPage() {
        return "resource-request/resource-request-submit-successful";
    }

    @GetMapping("/manage-resource-request")
    public String showManageRequestsPage(@RequestParam(defaultValue = "pending") String status, Model model) {
        try {
            // Add all counts for the status cards
            List<ResourceRequestModel> pendingRequests = resourceRequestService.findByStatus("pending");
            List<ResourceRequestModel> approvedRequests = resourceRequestService.findByStatus("approved");
            List<ResourceRequestModel> rejectedRequests = resourceRequestService.findByStatus("rejected");
            
            model.addAttribute("pendingRequests", pendingRequests);
            model.addAttribute("approvedRequests", approvedRequests);
            model.addAttribute("rejectedRequests", rejectedRequests);
            
            // Add the filtered requests based on status
            model.addAttribute("requests", resourceRequestService.findByStatus(status.toLowerCase()));
            model.addAttribute("currentStatus", status.toLowerCase());
            
            return "resource-request/manage-resource-request-dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred while loading the requests.");
            return "error";
        }
    }

    @PostMapping("/manage/{id}/approve")
    public String approveRequest(@PathVariable String id, 
                               @RequestParam int approvedQuantity, 
                               @RequestParam String feedback,
                               RedirectAttributes redirectAttributes) {
        resourceRequestService.approveRequest(id, approvedQuantity, feedback);
        redirectAttributes.addFlashAttribute("message", "Request approved successfully");
        return "redirect:/manage";
    }

    @PostMapping("/manage/{id}/reject")
    public String rejectRequest(@PathVariable String id, 
                              @RequestParam String feedback,
                              RedirectAttributes redirectAttributes) {
        try {
            resourceRequestService.rejectRequest(id, feedback);
            redirectAttributes.addFlashAttribute("message", "Request rejected successfully");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Failed to reject request");
        }
        return "redirect:/manage";
    }
}

