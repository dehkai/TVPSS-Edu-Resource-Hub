package com.codecrafters.tvpss.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resource_requests")
public class ResourceRequestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "school_name", nullable = false)
    private String schoolName;
    
    @Column(name = "school_code", nullable = false)
    private String schoolCode;
    
    @Column(name = "resource_type", nullable = false)
    private String resourceType;
    
    private int quantity;
    
    @Column(length = 1000)
    private String description;
    
    @Column(length = 1000)
    private String justification;
    
    @Column(name = "date_needed")
    private LocalDate dateNeeded;
    
    private String priority;
    
    @Column(name = "additional_comment", length = 1000)
    private String additionalComment;
    
    @Column(nullable = false)
    private String status = "pending"; // "pending", "approved", "rejected"
    
    @Column(name = "date_submitted")
    private LocalDate dateSubmitted;
    
    @Column(name = "approved_quantity")
    private int approvedQuantity;
    
    @Column(length = 1000)
    private String feedback;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public LocalDate getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(LocalDate dateNeeded) {
        this.dateNeeded = dateNeeded;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public int getApprovedQuantity() {
        return approvedQuantity;
    }

    public void setApprovedQuantity(int approvedQuantity) {
        this.approvedQuantity = approvedQuantity;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
