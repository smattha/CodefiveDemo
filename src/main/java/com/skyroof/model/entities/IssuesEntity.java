package com.skyroof.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "issues", schema = "skyroof")
public class IssuesEntity {
    private int issueid;
    private String title;
    private String issueDescription;
    private String issueType;
    private String otherDetails;
    private byte isHidden;
    private int projectid;
    private int statusid;
    private int assignor;
    private int assignee;
    private String createdBy;

    public IssuesEntity() {
    }

    public IssuesEntity(String title, String issueDescription, String issueType, String otherDetails, byte isHidden, int projectid, int statusid, int assignor, int assignee, String createdBy) {
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

    @Id
    @Column(name = "issueid")
    public int getIssueId() {
        return issueid;
    }

    public void setIssueId(int issueid) {
        this.issueid = issueid;
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
    @Column(name = "issue_description")
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Basic
    @Column(name = "issue_type")
    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Basic
    @Column(name = "other_details")
    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Basic
    @Column(name = "is_hidden")
    public byte getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(byte isHidden) {
        this.isHidden = isHidden;
    }

    @Basic
    @Column(name = "projectid")
    public int getProjectId() {
        return projectid;
    }

    public void setProjectId(int projectid) {
        this.projectid = projectid;
    }

    @Basic
    @Column(name = "statusid")
    public int getStatusId() {
        return statusid;
    }

    public void setStatusId(int statusid) {
        this.statusid = statusid;
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


    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuesEntity that = (IssuesEntity) o;
        return issueid == that.issueid &&
                isHidden == that.isHidden &&
                projectid == that.projectid &&
                statusid == that.statusid &&
                assignor == that.assignor &&
                assignee == that.assignee &&
                title.equals(that.title) &&
                issueDescription.equals(that.issueDescription) &&
                issueType.equals(that.issueType) &&
                otherDetails.equals(that.otherDetails) &&
                createdBy.equals(that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueid, title, issueDescription, issueType, otherDetails, isHidden, projectid, statusid, assignor, assignee);
    }

    @Override
    public String toString() {
        return "IssuesEntity{" +
                "issueid=" + issueid +
                ", title='" + title + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueType='" + issueType + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", isHidden=" + isHidden +
                ", projectid=" + projectid +
                ", statusid=" + statusid +
                ", assignor=" + assignor +
                ", assignee=" + assignee +
                '}';
        //SkyroofServer.logger.i
    }
}
