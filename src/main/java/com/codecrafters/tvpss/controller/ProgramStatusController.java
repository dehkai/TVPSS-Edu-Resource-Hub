package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ProgramStatusModel;
import com.codecrafters.tvpss.service.ProgramStatusService;

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
public class ProgramStatusController {

    @Autowired
    private ProgramStatusService programStatusService;

    @GetMapping("/submit-status")
    public String showForm(Model model) {
        model.addAttribute("submitStatus", new ProgramStatusModel());
        return "programs'-status/programs'-status-form";
    }

}
