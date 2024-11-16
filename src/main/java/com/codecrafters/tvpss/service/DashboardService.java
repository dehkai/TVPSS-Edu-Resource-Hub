package com.codecrafters.tvpss.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DashboardService {

    public DashboardData getDashboardDataForRole(String role) {
        DashboardData dashboardData = new DashboardData();

        switch (role) {
            case "Student":
                dashboardData.setTopInterviewers(fetchTopInterviewers());
                dashboardData.setEvents(fetchEvents());
                dashboardData.setEnrolledCourses(fetchEnrolledCourses());
                break;
            case "Officer":
                dashboardData.setRecommendedCandidates(fetchRecommendedCandidates());
                dashboardData.setValidationReports(fetchValidationReports());
                break;
            case "Admin":
                dashboardData.setRecommendedCandidates(fetchRecommendedCandidates());
                dashboardData.setInterviews(fetchInterviews());
                dashboardData.setApplications(fetchApplications());
                break;
        }

        return dashboardData;
    }

    private List<User> fetchTopInterviewers() { /*...*/ }
    private List<Event> fetchEvents() { /*...*/ }
    private List<Course> fetchEnrolledCourses() { /*...*/ }
    private List<ValidationReport> fetchValidationReports() { /*...*/ }
    private List<Interview> fetchInterviews() { /*...*/ }
    private List<Application> fetchApplications() { /*...*/ }
}
