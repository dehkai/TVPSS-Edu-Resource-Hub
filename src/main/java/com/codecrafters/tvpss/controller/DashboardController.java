package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.service.DashboardService;
import com.codecrafters.tvpss.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String defaultRedirect(Authentication authentication) {
        if (authentication != null && authentication.getAuthorities() != null) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:/dashboard/admin";
                } else if (authority.getAuthority().equals("ROLE_OFFICER")) {
                    return "redirect:/dashboard/officer";
                } else if (authority.getAuthority().equals("ROLE_STUDENT")) {
                    return "redirect:/dashboard/student";
                }
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/dashboard/admin")
    public String adminDashboard(Model model) {
        Dashboard dashboard = dashboardService.getAdminDashboard();
        model.addAttribute("dashboard", dashboard);
        return "dashboard-admin";
    }

    @GetMapping("/dashboard/officer")
    public String officerDashboard(Model model) {
        Dashboard dashboard = dashboardService.getOfficerDashboard();
        model.addAttribute("dashboard", dashboard);
        return "dashboard-officer";
    }

    @GetMapping("/dashboard/student")
    public String studentDashboard(Model model) {
        Dashboard dashboard = dashboardService.getStudentDashboard();
        model.addAttribute("dashboard", dashboard);
        return "dashboard-student";
    }
}
