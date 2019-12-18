package com.skyroof.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "issuestatus", schema = "skyroof")
public class IssuestatusEntity {
    private int statusid;
    private String statusDescription;

    @Id
    @Column(name = "statusid")
    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    @Basic
    @Column(name = "status_description")
    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuestatusEntity that = (IssuestatusEntity) o;
        return statusid == that.statusid &&
                Objects.equals(statusDescription, that.statusDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusid, statusDescription);
    }
}
