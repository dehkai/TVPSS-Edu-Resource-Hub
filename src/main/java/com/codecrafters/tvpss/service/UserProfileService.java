package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.dao.UserProfileDao;
import com.codecrafters.tvpss.model.TalentApplicationModel;
import com.codecrafters.tvpss.model.UserProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    private final List<TalentApplicationModel> talentRequests = new ArrayList<>();

    public List<TalentApplicationModel> getPendingRequests() {
        // Filter requests with status "pending"
        return talentRequests.stream()
                .filter(request -> "pending".equals(request.getStatus()))
                .toList();
    }

    public UserProfileModel findByUsername(String username) {
        return userProfileDao.findByUsername(username);
    }

}
