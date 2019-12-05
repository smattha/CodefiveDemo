package com.skyroof.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class IssuesEntityPK implements Serializable {
    private int issueId;
    private int projectId;
    private int statusId;

    @Column(name = "issueID")
    @Id
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Column(name = "projectID")
    @Id
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Column(name = "statusID")
    @Id
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuesEntityPK that = (IssuesEntityPK) o;
        return issueId == that.issueId &&
                projectId == that.projectId &&
                statusId == that.statusId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, projectId, statusId);
    }
}
