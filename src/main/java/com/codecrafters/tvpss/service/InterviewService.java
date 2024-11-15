package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.InterviewModel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {
    private final List<InterviewModel> interviewRequests = new ArrayList<>();

    public List<InterviewModel> getPendingRequests() {
        // Filter requests with status "pending"
        return interviewRequests.stream()
                .filter(request -> "pending".equals(request.getStatus()))
                .toList();
    }

//    public void approveRequest(Long id) {
//        resourceRequests.stream()
//                .filter(request -> request.getId().equals(id))
//                .findFirst()
//                .ifPresent(request -> request.setStatus("approved"));
//    }

//    public void rejectRequest(Long id) {
//        resourceRequests.stream()
//                .filter(request -> request.getId().equals(id))
//                .findFirst()
//                .ifPresent(request -> request.setStatus("rejected"));
//    }
//
//    // Method to add a new request (for testing purposes)
//    public void addRequest(ResourceRequestModel request) {
//        resourceRequests.add(request);
//    }
//    @PostConstruct
//    public void init() {
//
//        ResourceRequestModel testRequest = new ResourceRequestModel();
//        testRequest.setId(1L);
//        testRequest.setSchoolName("Test School");
//        testRequest.setResourceType("Books");
//        testRequest.setQuantity(10);
//        testRequest.setStatus("pending");
//        addRequest(testRequest);
//    }
}
