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

    public void approveRequest(String id) {
        repository.findById(id).ifPresent(request -> {
            request.setStatus("approved");
            repository.save(request);
        });
    }

    public void rejectRequest(String id) {
        repository.findById(id).ifPresent(request -> {
            request.setStatus("rejected");
            repository.save(request);
        });
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
