package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.dao.UserProfileDao;
import com.codecrafters.tvpss.model.InterviewModel;
import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.model.UserProfileModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    public UserProfileModel findById(int id) {
        return userProfileDao.findById(id);
    }

    public UserProfileModel findByUsername(String username) {
        return userProfileDao.findByUsername(username);
    }


    public void updateUserProfile(UserProfileModel userProfile) {
        userProfileDao.update(userProfile);
    }

    public List<UserProfileModel> getAllPostTalent() {
        return userProfileDao.findAll();
    }


}
