package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ProgramStatusModel;
import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProgramStatusController {

    @Autowired
    private ResourceRequestService resourceRequestService;

    @GetMapping("/program-status-form")
    public String showForm(Model model) {
        model.addAttribute("programStatusRequest", new ProgramStatusModel());
        return "school-program-status-form";
    }

    @GetMapping("/manage-program-status-list")
    public String showManageProgramStatusList(Model model) {
        model.addAttribute("programStatusRequest", new ProgramStatusModel());
        return "manage-school-program-status";
    }

    @GetMapping("/program-status-list")
    public String showProgramStatusList(Model model) {
        model.addAttribute("programStatusRequest", new ProgramStatusModel());
        return "school-program-status-list";
    }

    @GetMapping("/program-status-report")
    public String showProgramStatusReport(Model model) {
        model.addAttribute("programStatusRequest", new ProgramStatusModel());
        return "school-program-status-report";
    }

}
