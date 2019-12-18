package com.skyroof.datatypes;

public class IssueEnt {
    private int issueid;
    private String title;
    private String issueDescription;
    private String issueType;
    private String otherDetails;
    private byte isHidden;
    private int projectid;
    private int statusid;
    private String assignor;
    private String assignee;
    private String createdBy;

    public IssueEnt() {
    }

    public IssueEnt(int issueid, String title, String issueDescription, String issueType, String otherDetails, byte isHidden, int projectid, int statusid, String assignor, String assignee, String createdBy) {
        this.issueid = issueid;
        this.title = title;
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.otherDetails = otherDetails;
        this.isHidden = isHidden;
        this.projectid = projectid;
        this.statusid = statusid;
        this.assignor = assignor;
        this.assignee = assignee;
        this.createdBy = createdBy;
    }

    public int getIssueid() {
        return issueid;
    }

    public void setIssueid(int issueid) {
        this.issueid = issueid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public byte getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(byte isHidden) {
        this.isHidden = isHidden;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "IssueEnt{" +
                "issueid=" + issueid +
                ", title='" + title + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueType='" + issueType + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", isHidden=" + isHidden +
                ", projectid=" + projectid +
                ", statusid=" + statusid +
                ", assignor='" + assignor + '\'' +
                ", assignee='" + assignee + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
