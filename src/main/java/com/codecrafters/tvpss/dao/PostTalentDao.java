package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codecrafters.tvpss.model.TalentPostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostTalentDao {
    private static final Logger logger = LoggerFactory.getLogger(PostTalentDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TalentPostModel findById(Long id) {
        String sql = "SELECT * FROM post_talent WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new TalentPostRowMapper(), id);
    }

    public List<TalentPostModel> findAll() {
        String sql = "SELECT * FROM post_talent ORDER BY id ASC";
        try {
            return jdbcTemplate.query(sql, new TalentPostRowMapper());
        } catch (Exception e) {
            logger.error("Error fetching post talent data: ", e);
            // You can throw a custom exception or return an empty list, depending on your needs.
        }
        return List.of();
    }

    public void save(TalentPostModel request) {
        String sql = "INSERT INTO post_talent (talent_name, description, due_date, status) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                request.getTalentName(),
                request.getDescription(),
                request.getDueDate(),
                request.getStatus()
        );
    }

    public void update(TalentPostModel request) {
        logger.info("Updating post talent data: " + request.getDescription());
        String sql = "UPDATE post_talent SET talent_name=?, description=?, due_date=?, " +
                "status=? WHERE id=?";
        try {
        jdbcTemplate.update(sql,
                request.getTalentName(),
                request.getDescription(),
                request.getDueDate(),
                request.getStatus(),
                request.getId()
        );
        } catch (Exception e) {
            logger.error("Error fetching post talent data: ", e);
            // You can throw a custom exception or return an empty list, depending on your needs.
        }
    }

    private static class TalentPostRowMapper implements RowMapper<TalentPostModel> {
        @Override
        public TalentPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TalentPostModel request = new TalentPostModel();
            request.setId(rs.getLong("id"));
            request.setTalentName(rs.getString("talent_name"));
            request.setDescription(rs.getString("description"));
            request.setDueDate(rs.getString("due_date"));
            request.setStatus(rs.getString("status"));
            return request;
        }
    }

}