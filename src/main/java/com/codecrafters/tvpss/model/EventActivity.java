package com.codecrafters.tvpss.model;

import java.sql.Date;

public class EventActivity {
    private Long id;
    private String title;
    private String imageUrl;
    private String description;
    private Date date;
    private String time;
    private String location;
    private String details;
    private int participantsCount = 0; // Default value
    private double rating = 0.0;      // Default value
    private String status = "Pending"; // Default value    

    // Constructors, Getters, and Setters
    public EventActivity() {}

    public EventActivity(Long id, String title, String imageUrl, String description, Date date, String time, String location, String details, int participantsCount, double rating, String status) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
        this.details = details;
        this.participantsCount = participantsCount;
        this.rating = rating;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }
    
    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }    

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }    

    public EventActivity orElseThrow(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}
