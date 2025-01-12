package com.codecrafters.tvpss.model;

public class TalentPostCandidateModel {
    private Long id;
    private int post_talent_id;
    private int user_profile_id;
    private int interview_id;
    private String talent_name;
    private String username;
    private String name;
    private int age;
    private String apply_date;
    private String candidate_status;
    private String feedback;
    private String interview_status;
    private String interview_date;
    private String interview_time;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPost_talent_id() {
        return post_talent_id;
    }

    public void setPost_talent_id(int post_talent_id) {
        this.post_talent_id = post_talent_id;
    }

    public int getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(int user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public String getTalent_name() {
        return talent_name;
    }

    public void setTalent_name(String talent_name) {
        this.talent_name = talent_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public String getCandidate_status() {
        return candidate_status;
    }

    public void setCandidate_status(String candidate_status) {
        this.candidate_status = candidate_status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getInterview_status() {
        return interview_status;
    }

    public void setInterview_status(String interview_status) {
        this.interview_status = interview_status;
    }

    public String getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(String interview_date) {
        this.interview_date = interview_date;
    }

    public String getInterview_time() {
        return interview_time;
    }

    public void setInterview_time(String interview_time) {
        this.interview_time = interview_time;
    }

    public int getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(int interview_id) {
        this.interview_id = interview_id;
    }
}
