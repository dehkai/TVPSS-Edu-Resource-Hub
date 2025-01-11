package com.codecrafters.tvpss.model;

import java.time.LocalDate;

public class InterviewModel {

    private int id;
    private int post_talent_id;
    private String time;
    private String date;
    private String feedback;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_talent_id() {
        return post_talent_id;
    }

    public void setPost_talent_id(int post_talent_id) {
        this.post_talent_id = post_talent_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
