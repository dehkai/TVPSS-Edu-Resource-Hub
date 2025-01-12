package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.service.DashboardService;
import com.codecrafters.tvpss.model.Dashboard;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dashboard")
    public String defaultRedirect(Authentication authentication, HttpSession session) {
        if (authentication != null && authentication.getAuthorities() != null) {
            String username = authentication.getName();
            session.setAttribute("username", username);
            
            session.setAttribute("schoolCode", "");
            session.setAttribute("schoolName", "");
            
            try {
                jdbcTemplate.queryForObject(
                    "SELECT school_code, school_name FROM auth WHERE username = ?",
                    (rs, rowNum) -> {
                        String schoolCode = rs.getString("school_code");
                        String schoolName = rs.getString("school_name");
                        if (schoolCode != null) {
                            session.setAttribute("schoolCode", schoolCode);
                        }
                        if (schoolName != null) {
                            session.setAttribute("schoolName", schoolName);
                        }
                        return null;
                    },
                    username
                );
            } catch (DataAccessException e) {
                System.err.println("Error fetching school info: " + e.getMessage());
            }
            
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority().replace("ROLE_", "");
                session.setAttribute("userRole", role);
                
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
        return "dashboard/dashboard-admin";
    }

    @GetMapping("/dashboard/officer")
    public String officerDashboard(Model model) {
        Dashboard dashboard = dashboardService.getOfficerDashboard();
        model.addAttribute("dashboard", dashboard);
        return "dashboard/dashboard-officer";
    }

    @GetMapping("/dashboard/student")
    public String studentDashboard(Model model) {
        Dashboard dashboard = dashboardService.getStudentDashboard();
        model.addAttribute("dashboard", dashboard);
        return "dashboard/dashboard-student";
    }
}
