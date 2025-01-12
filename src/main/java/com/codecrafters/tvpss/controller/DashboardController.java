package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.model.UserProfileModel;
import com.codecrafters.tvpss.service.DashboardService;
import com.codecrafters.tvpss.service.TalentApplicationService;
import com.codecrafters.tvpss.service.UserProfileService;
import com.codecrafters.tvpss.model.Dashboard;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;
    @Autowired
    private TalentApplicationService talentApplicationService;
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/dashboard")
    public String defaultRedirect(Authentication authentication, HttpSession session) {
        if (authentication != null && authentication.getAuthorities() != null) {
            // Store username in session
            session.setAttribute("username", authentication.getName());
            
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority().replace("ROLE_", "");
                // Store role in session
                session.setAttribute("userRole", role);
                //String userRole = (String) session.getAttribute("userRole");
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
    public String studentDashboard(HttpSession session,Model model) {
        Dashboard dashboard = dashboardService.getStudentDashboard();
        List<TalentPostModel> threetalentPostList = talentApplicationService.getThreePostTalent();
        model.addAttribute("threetalentPostList", threetalentPostList);
        model.addAttribute("dashboard", dashboard);
        String userName = (String) session.getAttribute("username");
        UserProfileModel userProfileModel = userProfileService.findByUsername(userName);
        model.addAttribute("userProfile", userProfileModel);
        System.out.println("This is Username " + userProfileModel.getAbout_me());
        return "dashboard/dashboard-student";
    }
}
