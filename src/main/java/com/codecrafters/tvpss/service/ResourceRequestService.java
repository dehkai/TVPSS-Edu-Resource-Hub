package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.dao.ResourceRequestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;

@Service
public class ResourceRequestService {

    @Autowired
    private ResourceRequestDao resourceRequestDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public List<ResourceRequestModel> findBySchoolCode(String schoolCode) {
        String sql = "SELECT * FROM resource_requests WHERE school_code = ? ORDER BY date_submitted DESC";
        return jdbcTemplate.query(sql, new Object[]{schoolCode}, (rs, rowNum) -> {
            ResourceRequestModel request = new ResourceRequestModel();
            request.setId(rs.getLong("id"));
            request.setSchoolCode(rs.getString("school_code"));
            request.setSchoolName(rs.getString("school_name"));
            request.setResourceType(rs.getString("resource_type"));
            request.setQuantity(rs.getInt("quantity"));
            request.setDescription(rs.getString("description"));
            request.setJustification(rs.getString("justification"));
            
            java.sql.Date dateNeeded = rs.getDate("date_needed");
            if (dateNeeded != null) {
                request.setDateNeeded(dateNeeded.toLocalDate());
            }
            
            request.setPriority(rs.getString("priority"));
            request.setStatus(rs.getString("status"));
            
            java.sql.Date dateSubmitted = rs.getDate("date_submitted");
            if (dateSubmitted != null) {
                request.setDateSubmitted(dateSubmitted.toLocalDate());
            }
            
            request.setAdditionalComment(rs.getString("additional_comment"));
            request.setApprovedQuantity(rs.getInt("approved_quantity"));
            request.setFeedback(rs.getString("feedback"));
            return request;
        });
    }
}
