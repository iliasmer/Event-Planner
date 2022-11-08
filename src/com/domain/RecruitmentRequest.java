package com.domain;

public class RecruitmentRequest extends Request{

    String contractType;
    String department;
    Integer yearsOfExperience;
    String jobTitle;
    String jobDescription;
    AcceptRejectState state;

    public RecruitmentRequest(String contractType, String department, Integer yearsOfExperience, String jobTitle, String jobDescription) {
        setContractType(contractType);
        setDepartment(department);
        setYearsOfExperience(yearsOfExperience);
        setJobTitle(jobTitle);
        setJobDescription(jobDescription);
        this.state = AcceptRejectState.NEW;
    }

    public AcceptRejectState getState() {
        return state;
    }

    public void setState(AcceptRejectState state) {
        this.state = state;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        if (contractType == null) throw new NullPointerException("Contract Type can not be null.");
        if (contractType.isEmpty()) throw new IllegalArgumentException("Contract Type can not empty.");
        this.contractType = contractType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        if (yearsOfExperience < 0) {throw new IllegalArgumentException("Years of Experience should not be negative");}
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (jobTitle == null) throw new NullPointerException("Job Title can not be null.");
        if (jobTitle.isEmpty()) throw new IllegalArgumentException("Job Title Type can not empty.");
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        if (jobTitle == null) throw new NullPointerException("Job Description can not be null.");
        if (jobTitle.isEmpty()) throw new IllegalArgumentException("Job Description Type can not empty.");
        this.jobDescription = jobDescription;
    }
}
