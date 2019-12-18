package com.skyroof.datatypes;

//custom class created to return to the front end just the necessary issue data to create the tables
public class IssueObject {
    private String projectTitle;
    private String issueTitle;
    private String assignor;
    private int status;
    private String type;
    private String permission;
    private int issueId;

    public IssueObject() {
    }

    public IssueObject(String projectTitle, String issueTitle, String assignor, int status, String type, String permission, int issueId) {
        this.projectTitle = projectTitle;
        this.issueTitle = issueTitle;
        this.assignor = assignor;
        this.status = status;
        this.type = type;
        this.permission = permission;
        this.issueId = issueId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Override
    public String toString() {
        return "IssueObject{" +
                "projectTitle='" + projectTitle + '\'' +
                ", issueTitle='" + issueTitle + '\'' +
                ", assignor='" + assignor + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", permission='" + permission + '\'' +
                ", issueId=" + issueId +
                '}';
    }
}
