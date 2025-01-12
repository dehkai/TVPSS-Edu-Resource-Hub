package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.model.TalentPostCandidateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;

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

    public List<TalentPostCandidateModel> findAllCandidate() {
        String sql = "SELECT ptc.id AS candidate_id, pt.talent_name, up.username, up.name, ptc.post_talent_id , ptc.user_profile_id , ptc.interview_id, " +
                "up.age, ptc.apply_date, ptc.candidate_status , i.feedback, i.status AS interview_status, i.date AS interview_date, i.time AS interview_time " +
                "FROM post_talent_candidate ptc " +
                "JOIN post_talent pt ON ptc.post_talent_id = pt.id " +
                "JOIN user_profile up ON ptc.user_profile_id = up.id " +
                "JOIN interview i ON ptc.interview_id = i.id " +
                "ORDER BY ptc.apply_date DESC";
        try {
            return jdbcTemplate.query(sql, new TalentPostCandidateRowMapper());
        } catch (Exception e) {
            logger.error("Error fetching post talent data: ", e);
            // You can throw a custom exception or return an empty list, depending on your needs.
        }
        return List.of();
    }

    public List<TalentPostModel> findThreePost() {
        String sql = "SELECT * FROM post_talent ORDER BY id ASC LIMIT 3";
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

    public void addPostCandidate(TalentPostModel request, int user_profile_id, int interview_id) {
        String sql = "INSERT INTO post_talent_candidate (post_talent_id, user_profile_id, apply_date, candidate_status,interview_id) " +
                "VALUES (?, ?, ?, ?,?)";

        jdbcTemplate.update(sql,
                request.getId(),
                user_profile_id,
                LocalDate.now(),
                "Pending",
                interview_id
        );
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

    private static class TalentPostCandidateRowMapper implements RowMapper<TalentPostCandidateModel> {
        @Override
        public TalentPostCandidateModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TalentPostCandidateModel candidate = new TalentPostCandidateModel();
            candidate.setId(rs.getLong("candidate_id"));
            candidate.setPost_talent_id(rs.getInt("post_talent_id"));
            candidate.setUser_profile_id(rs.getInt("user_profile_id"));
            candidate.setInterview_id(rs.getInt("interview_id"));
            candidate.setFeedback(rs.getString("feedback"));
            candidate.setInterview_status(rs.getString("interview_status"));
            candidate.setInterview_date(rs.getString("interview_date"));
            candidate.setInterview_time(rs.getString("interview_time"));
            candidate.setTalent_name(rs.getString("talent_name"));
            candidate.setUsername(rs.getString("username"));
            candidate.setName(rs.getString("name"));
            candidate.setAge(rs.getInt("age"));
            candidate.setApply_date(rs.getString("apply_date"));
            candidate.setCandidate_status(rs.getString("candidate_status"));
            return candidate;
        }
    }

}