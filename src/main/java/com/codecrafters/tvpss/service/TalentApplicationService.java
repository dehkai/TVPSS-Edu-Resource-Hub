package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.TalentApplicationModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalentApplicationService {

    private final List<TalentApplicationModel> talentRequests = new ArrayList<>();

    public List<TalentApplicationModel> getPendingRequests() {
        // Filter requests with status "pending"
        return talentRequests.stream()
                .filter(request -> "pending".equals(request.getStatus()))
                .toList();
    }

}
