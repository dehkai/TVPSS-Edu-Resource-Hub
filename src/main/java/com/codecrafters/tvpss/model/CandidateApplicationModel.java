package com.codecrafters.tvpss.model;

public class CandidateApplicationModel {

    private Long id;
    private String jobType;
    private String employmentType;
    private String consideration;
    private String candidateName;
    private String address;
    private String aboutMeDescription;
    private String requirementDescription;

    public String getRequirementDescription() {
        return requirementDescription;
    }

    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }

    public String getAboutMeDescription() {
        return aboutMeDescription;
    }

    public void setAboutMeDescription(String aboutMeDescription) {
        this.aboutMeDescription = aboutMeDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getConsideration() {
        return consideration;
    }

    public void setConsideration(String consideration) {
        this.consideration = consideration;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
