package com.codecrafters.tvpss.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "program_status")
public class ProgramStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_code", nullable = false)
    private String schoolCode;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "version_criteria", nullable = false)
    private String versionCriteria; // Stored as JSON

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Column(name = "version", nullable = false)
    private int version;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "status")
    private String status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getVersionCriteria() {
        return versionCriteria;
    }

    public void setVersionCriteria(String versionCriteria) {
        this.versionCriteria = versionCriteria;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    // Transient fields for the checkboxes
    @Transient
    private String v1_name;
    @Transient
    private String v1_logo;
    @Transient
    private String v1_studio;
    @Transient
    private String v2_recording;
    @Transient
    private String v2_upload;
    @Transient
    private String v3_recording_out;
    @Transient
    private String v3_collaborate;
    @Transient
    private String v4_green_screen;

    // Getters and Setters for the transient fields
    public String getV1_name() {
        return v1_name;
    }

    public void setV1_name(String v1_name) {
        this.v1_name = v1_name;
    }

    public String getV1_logo() {
        return v1_logo;
    }

    public void setV1_logo(String v1_logo) {
        this.v1_logo = v1_logo;
    }

    public String getV1_studio() {
        return v1_studio;
    }

    public void setV1_studio(String v1_studio) {
        this.v1_studio = v1_studio;
    }

    public String getV2_recording() {
        return v2_recording;
    }

    public void setV2_recording(String v2_recording) {
        this.v2_recording = v2_recording;
    }

    public String getV2_upload() {
        return v2_upload;
    }

    public void setV2_upload(String v2_upload) {
        this.v2_upload = v2_upload;
    }

    public String getV3_recording_out() {
        return v3_recording_out;
    }

    public void setV3_recording_out(String v3_recording_out) {
        this.v3_recording_out = v3_recording_out;
    }

    public String getV3_collaborate() {
        return v3_collaborate;
    }

    public void setV3_collaborate(String v3_collaborate) {
        this.v3_collaborate = v3_collaborate;
    }

    public String getV4_green_screen() {
        return v4_green_screen;
    }

    public void setV4_green_screen(String v4_green_screen) {
        this.v4_green_screen = v4_green_screen;
    }
}
