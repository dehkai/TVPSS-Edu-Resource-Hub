package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import com.codecrafters.tvpss.dao.PostTalentDao;
import com.codecrafters.tvpss.model.TalentApplicationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalentApplicationService {

    @Autowired
    private PostTalentDao postTalentDao;

    private final List<TalentApplicationModel> talentRequests = new ArrayList<>();

    public List<TalentApplicationModel> getPendingRequests() {
        // Filter requests with status "pending"
        return talentRequests.stream()
                .filter(request -> "pending".equals(request.getStatus()))
                .toList();
    }

    public TalentPostModel findById(String id) {
            return postTalentDao.findById(Long.parseLong(id));
    }

    public List<TalentPostModel> getAllPostTalent() {
        return postTalentDao.findAll();
    }

    public TalentPostModel addPost(TalentPostModel request) {
        postTalentDao.save(request);
        return request;
    }

    public void  updatePost(TalentPostModel request) {
        postTalentDao.update(request);
    }

}
