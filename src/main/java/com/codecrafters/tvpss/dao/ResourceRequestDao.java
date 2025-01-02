package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResourceRequestDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ResourceRequestModel> findByStatus(String status) {
        String sql = "SELECT * FROM resource_requests WHERE LOWER(status) = ?";
        return jdbcTemplate.query(sql, new ResourceRequestRowMapper(), status.toLowerCase());
    }

    public ResourceRequestModel findById(Long id) {
        String sql = "SELECT * FROM resource_requests WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ResourceRequestRowMapper(), id);
    }

    public void save(ResourceRequestModel request) {
        String sql = "INSERT INTO resource_requests (school_name, school_code, resource_type, " +
                    "quantity, description, justification, date_needed, priority, additional_comment, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql,
            request.getSchoolName(),
            request.getSchoolCode(),
            request.getResourceType(),
            request.getQuantity(),
            request.getDescription(),
            request.getJustification(),
            request.getDateNeeded(),
            request.getPriority(),
            request.getAdditionalComment(),
            request.getStatus()
        );
    }

    public void update(ResourceRequestModel request) {
        String sql = "UPDATE resource_requests SET school_name=?, school_code=?, resource_type=?, " +
                    "quantity=?, description=?, justification=?, date_needed=?, priority=?, " +
                    "additional_comment=?, status=?, approved_quantity=?, feedback=? WHERE id=?";
        
        jdbcTemplate.update(sql,
            request.getSchoolName(),
            request.getSchoolCode(),
            request.getResourceType(),
            request.getQuantity(),
            request.getDescription(),
            request.getJustification(),
            request.getDateNeeded(),
            request.getPriority(),
            request.getAdditionalComment(),
            request.getStatus(),
            request.getApprovedQuantity(),
            request.getFeedback(),
            request.getId()
        );
    }

    public void delete(Long id) {
        String sql = "DELETE FROM resource_requests WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<ResourceRequestModel> findAll() {
        String sql = "SELECT * FROM resource_requests";
        return jdbcTemplate.query(sql, new ResourceRequestRowMapper());
    }

    private static class ResourceRequestRowMapper implements RowMapper<ResourceRequestModel> {
        @Override
        public ResourceRequestModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ResourceRequestModel request = new ResourceRequestModel();
            request.setId(rs.getLong("id"));
            request.setSchoolName(rs.getString("school_name"));
            request.setSchoolCode(rs.getString("school_code"));
            request.setResourceType(rs.getString("resource_type"));
            request.setQuantity(rs.getInt("quantity"));
            request.setDescription(rs.getString("description"));
            request.setJustification(rs.getString("justification"));
            request.setDateNeeded(rs.getDate("date_needed").toLocalDate());
            request.setPriority(rs.getString("priority"));
            request.setAdditionalComment(rs.getString("additional_comment"));
            request.setStatus(rs.getString("status"));
            request.setApprovedQuantity(rs.getInt("approved_quantity"));
            request.setFeedback(rs.getString("feedback"));
            return request;
        }
    }
}