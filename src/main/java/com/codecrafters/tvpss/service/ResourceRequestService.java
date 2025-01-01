package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.dao.ResourceRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ResourceRequestService {

    @Autowired
    private ResourceRequestDao resourceRequestDao;

    public List<ResourceRequestModel> findByStatus(String status) {
        try {
            return resourceRequestDao.findByStatus(status.toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void approveRequest(String id, int approvedQuantity, String feedback) {
        ResourceRequestModel request = resourceRequestDao.findById(Long.parseLong(id));
        request.setStatus("approved");
        request.setApprovedQuantity(approvedQuantity);
        request.setFeedback(feedback);
        resourceRequestDao.update(request);
    }
    
    public void rejectRequest(String id, String feedback) {
        ResourceRequestModel request = resourceRequestDao.findById(Long.parseLong(id));
        request.setStatus("rejected");
        request.setFeedback(feedback);
        resourceRequestDao.update(request);
    }

    public ResourceRequestModel addRequest(ResourceRequestModel request) {
        resourceRequestDao.save(request);
        return request;
    }

    public ResourceRequestModel getRequestById(String id) {
        return resourceRequestDao.findById(Long.parseLong(id));
    }

    public void deleteRequest(String id) {
        resourceRequestDao.delete(Long.parseLong(id));
    }

    public List<ResourceRequestModel> getAllRequests() {
        return resourceRequestDao.findAll();
    }
}
