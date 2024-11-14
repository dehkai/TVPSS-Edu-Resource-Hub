package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResourceRequestController {
    @GetMapping("/resource-request")
    public String showForm(Model model) {
        model.addAttribute("resourceRequest", new ResourceRequestModel());
        return "resource-request-form";
    }

    @PostMapping("/submitRequest")
    public String submitForm(ResourceRequestModel request, Model model) {
        // Process the request object as needed
        model.addAttribute("message", "Request submitted successfully!");
        return "result"; // create a "result.html" page to show success message
    }
}
