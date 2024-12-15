package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.repository.ResourceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestService {

    @Autowired
    private ResourceRequestRepository repository;

    public List<ResourceRequestModel> getPendingRequests() {
        return repository.findAll().stream()
                .filter(request -> "pending".equalsIgnoreCase(request.getStatus()))
                .toList();
    }

    public void approveRequest(String id, int approvedQuantity, String feedback) {
        ResourceRequestModel request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("approved");
        request.setApprovedQuantity(approvedQuantity);
        request.setFeedback(feedback);
        repository.save(request);
    }
    
    public void rejectRequest(String id, String feedback) {
        ResourceRequestModel request = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("rejected");
        request.setFeedback(feedback);
        repository.save(request);
    }

    public ResourceRequestModel addRequest(ResourceRequestModel request) {
        return repository.save(request);
    }

    public ResourceRequestModel getRequestById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteRequest(String id) {
        repository.deleteById(id);
    }

    public List<ResourceRequestModel> getAllRequests() {
        return repository.findAll();
    }
}
