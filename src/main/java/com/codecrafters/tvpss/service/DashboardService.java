package com.codecrafters.tvpss.service;

import org.springframework.stereotype.Service;

import com.codecrafters.tvpss.model.Dashboard;

import java.util.Arrays;  // Import Arrays if using Arrays.asList() for example data

@Service
public class DashboardService {

    // Example method to fetch admin dashboard data
    public Dashboard getAdminDashboard() {
        // Assume fetching some data relevant to admin operations
        return new Dashboard("admin", Arrays.asList("Report 1", "Report 2"));
    }

    // Example method to fetch officer dashboard data
    public Dashboard getOfficerDashboard() {
        // Assume fetching data relevant to officer operations
        return new Dashboard("officer", Arrays.asList("Task 1", "Task 2"));
    }

    // Example method to fetch student dashboard data
    public Dashboard getStudentDashboard() {
        // Assume fetching data relevant to student activities
        return new Dashboard("student", Arrays.asList("Course 1", "Course 2"));
    }
}
