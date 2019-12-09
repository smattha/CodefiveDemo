package com.skyroof.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "issues", schema = "skyroof", catalog = "")
public class IssuesEntity {
    private int issueId;
    private String title;
    private String issueDescription;
    private String issueType;
    private String otherDetails;
    private byte isHidden;
    private int projectId;
    private int statusId;
    private int assignor;
    private int assignee;

    @Id
    @Column(name = "issueID")
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "issueDescription")
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Basic
    @Column(name = "issueType")
    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Basic
    @Column(name = "otherDetails")
    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Basic
    @Column(name = "isHidden")
    public byte getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(byte isHidden) {
        this.isHidden = isHidden;
    }

    @Basic
    @Column(name = "projectID")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "statusID")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "assignor")
    public int getAssignor() {
        return assignor;
    }

    public void setAssignor(int assignor) {
        this.assignor = assignor;
    }

    @Basic
    @Column(name = "assignee")
    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuesEntity that = (IssuesEntity) o;
        return issueId == that.issueId &&
                isHidden == that.isHidden &&
                projectId == that.projectId &&
                statusId == that.statusId &&
                assignor == that.assignor &&
                assignee == that.assignee &&
                Objects.equals(title, that.title) &&
                Objects.equals(issueDescription, that.issueDescription) &&
                Objects.equals(issueType, that.issueType) &&
                Objects.equals(otherDetails, that.otherDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, title, issueDescription, issueType, otherDetails, isHidden, projectId, statusId, assignor, assignee);
    }

    @Override
    public String toString() {
        return "IssuesEntity{" +
                "issueId=" + issueId +
                ", title='" + title + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueType='" + issueType + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", isHidden=" + isHidden +
                ", projectId=" + projectId +
                ", statusId=" + statusId +
                ", assignor=" + assignor +
                ", assignee=" + assignee +
                '}';
    }
}
