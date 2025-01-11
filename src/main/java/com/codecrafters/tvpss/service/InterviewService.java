package com.codecrafters.tvpss.service;

import com.codecrafters.tvpss.dao.PostTalentDao;
import com.codecrafters.tvpss.dao.InterviewDao;
import com.codecrafters.tvpss.model.InterviewModel;
import com.codecrafters.tvpss.model.TalentPostModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewDao interviewDao;

    private final List<InterviewModel> interviewRequests = new ArrayList<>();

    public void  addInterviewData(InterviewModel request) {
        interviewDao.addInterviewData(request);
    }

    public int createInterview(InterviewModel interview,int post_talent_id, String username) {
        return interviewDao.createInterview(interview,post_talent_id,username);
    }

    public void  updatePostCandidateId(int interview_id, int post_talent_candidate_id) {
        interviewDao.updatePostCandidateId(interview_id, post_talent_candidate_id);
    }

    public List<InterviewModel> getAllInterviews() {
        return interviewDao.findAll();
    }

    public InterviewModel getInterviewById(int id) {
        return interviewDao.findById(id);
    }

    public void addInterview(InterviewModel interview) {
        interviewDao.save(interview);
    }

    public void updateInterview(InterviewModel interview) {
        interviewDao.update(interview);
    }

    public void deleteInterview(int id) {
        interviewDao.deleteById(id);
    }



//    public void approveRequest(Long id) {
//        resourceRequests.stream()
//                .filter(request -> request.getId().equals(id))
//                .findFirst()
//                .ifPresent(request -> request.setStatus("approved"));
//    }

//    public void rejectRequest(Long id) {
//        resourceRequests.stream()
//                .filter(request -> request.getId().equals(id))
//                .findFirst()
//                .ifPresent(request -> request.setStatus("rejected"));
//    }
//
//    // Method to add a new request (for testing purposes)
//    public void addRequest(ResourceRequestModel request) {
//        resourceRequests.add(request);
//    }
//    @PostConstruct
//    public void init() {
//
//        ResourceRequestModel testRequest = new ResourceRequestModel();
//        testRequest.setId(1L);
//        testRequest.setSchoolName("Test School");
//        testRequest.setResourceType("Books");
//        testRequest.setQuantity(10);
//        testRequest.setStatus("pending");
//        addRequest(testRequest);
//    }
}
