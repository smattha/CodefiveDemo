package com.skyroof.datatypes;

public class QueryDetails {
    int projectId;
    String title;
    int assignor;
    int assignee;
    String issueType;
    int statusId;
    String username;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAssignor() {
        return assignor;
    }

    public void setAssignor(int assignor) {
        this.assignor = assignor;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QueryDetails{" +
                "projectId=" + projectId +
                ", title='" + title + '\'' +
                ", assignor=" + assignor +
                ", assignee=" + assignee +
                ", issueType='" + issueType + '\'' +
                ", statusId=" + statusId +
                ", username='" + username + '\'' +
                '}';
    }
}
