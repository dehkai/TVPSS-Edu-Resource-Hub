package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ProgramStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProgramStatusDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save a new program status
    public void save(ProgramStatusModel programStatus) {
        String sql = "INSERT INTO program_status (school_code, school_name, version_criteria, youtube_link, version, created_at) " +
                "VALUES (?, ?, ?::jsonb, ?, ?, ?)";
        jdbcTemplate.update(sql,
                programStatus.getSchoolCode(),
                programStatus.getSchoolName(),
                programStatus.getVersionCriteria(), // JSONB field
                programStatus.getYoutubeLink(),
                programStatus.getVersion(),
                programStatus.getCreatedAt()
        );
    }

    // Find a specific program status by ID
    public ProgramStatusModel findById(Long id) {
        String sql = "SELECT * FROM program_status WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ProgramStatusRowMapper(), id);
    }

    // Update an existing program status
    public void update(ProgramStatusModel programStatus) {
        String sql = "UPDATE program_status SET school_code = ?, school_name = ?, version_criteria = ?::jsonb, youtube_link = ?, version = ?, created_at = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                programStatus.getSchoolCode(),
                programStatus.getSchoolName(),
                programStatus.getVersionCriteria(), // JSONB field
                programStatus.getYoutubeLink(),
                programStatus.getVersion(),
                programStatus.getCreatedAt(),
                programStatus.getId()
        );
    }

    // Delete a program status by ID
    public void delete(Long id) {
        String sql = "DELETE FROM program_status WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Find all program statuses
    public List<ProgramStatusModel> findAll() {
        String sql = "SELECT * FROM program_status";
        return jdbcTemplate.query(sql, new ProgramStatusRowMapper());
    }

    // RowMapper for mapping SQL result set to ProgramStatusModel
    private static class ProgramStatusRowMapper implements RowMapper<ProgramStatusModel> {
        @Override
        public ProgramStatusModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProgramStatusModel programStatus = new ProgramStatusModel();
            programStatus.setId(rs.getLong("id"));
            programStatus.setSchoolCode(rs.getString("school_code"));
            programStatus.setSchoolName(rs.getString("school_name"));
            programStatus.setVersion(rs.getInt("version"));
            programStatus.setVersionCriteria(rs.getString("version_criteria")); // JSONB as string
            programStatus.setYoutubeLink(rs.getString("youtube_link"));
            programStatus.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            return programStatus;
        }
    }
}
