package com.skyroof.model.entities;

public class IssueImport {

    String title;
    String description;
    String type;
    String otherDetails;
    int assignor;
    int assignee;
    int statusId;
    int projectId;
    String username;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "IssueImport{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", assignor=" + assignor +
                ", assignee=" + assignee +
                ", statusId=" + statusId +
                ", projectId=" + projectId +
                ", username='" + username + '\'' +
                '}';
    }
}
