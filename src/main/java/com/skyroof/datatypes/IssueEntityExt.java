package com.skyroof.datatypes;


public class IssueEntityExt {

    private String title;
    private String description;
    private String type;
    private String otherDetails;
    private int id;
    private int assignee;
    private int statusId;
    private int projectId;
    private String username;




    public IssueEntityExt(String title, String description, String type, String otherDetails, int id, int assignee, int statusId, int projectId, String username) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.otherDetails = otherDetails;
        this.id = id;
        this.assignee = assignee;
        this.statusId = statusId;
        this.projectId = projectId;
        this.username = username;
    }

    @Override
    public String toString() {
        return "IssueEntityExt{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", id=" + id +
                ", assignee=" + assignee +
                ", statusId=" + statusId +
                ", projectId=" + projectId +
                ", username='" + username + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public int getId() {
        return id;
    }

    public int getAssignee() {
        return assignee;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getUsername() {
        return username;
    }
}
