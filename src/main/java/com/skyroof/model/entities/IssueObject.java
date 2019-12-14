package com.skyroof.model.entities;

public class IssueObject {
    String projectTitle;
    String issueTitle;
    String assignor;
    int status;
    String type;
    String permission;

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

    @Override
    public String toString() {
        return "OpenIssue{" +
                "projectTitle='" + projectTitle + '\'' +
                ", issueTitle='" + issueTitle + '\'' +
                ", assignor='" + assignor + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
