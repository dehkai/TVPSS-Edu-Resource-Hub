package com.codecrafters.tvpss.dao;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codecrafters.tvpss.model.UserProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserProfileDao {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserProfileModel findByUsername(String username) {
        String sql = "SELECT * FROM user_profile WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new UserProfileRowMapper(), username);
    }

    private static class UserProfileRowMapper implements RowMapper<UserProfileModel> {
        @Override
        public UserProfileModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserProfileModel request = new UserProfileModel();
            request.setId(rs.getInt("id"));  // Changed to rs.getInt
            request.setUsername(rs.getString("username"));
            request.setName(rs.getString("name"));
            request.setAge(rs.getInt("age"));  // Fixed incorrect syntax
            request.setAbout_me(rs.getString("about_me"));
            request.setSkill(rs.getString("skill"));
            request.setExperience(rs.getString("experience"));
            request.setAddress(rs.getString("address"));
            request.setQualifications(rs.getString("qualifications"));
            return request;
        }
    }
}
