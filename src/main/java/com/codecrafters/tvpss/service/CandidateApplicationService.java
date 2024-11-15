package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.model.CandidateApplicationModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateApplicationService {

    private final List<CandidateApplicationModel> candidateRequest = new ArrayList<>();

    public List<CandidateApplicationModel> getPendingRequests() {
        // Filter requests with status "pending"
        return candidateRequest.stream()
                .filter(request -> "pending".equals(request.getId()))
                .toList();
    }

}
