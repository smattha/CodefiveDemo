package com.skyroof.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permission", schema = "skyroof")
public class PermissionEntity {
    private int permissionid;
    private int userid;
    private int projectid;
    private String permissionDescription;

    @Id
    @Column(name = "permissionid")
    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "projectid")
    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    @Basic
    @Column(name = "permission_description")
    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return permissionid == that.permissionid &&
                userid == that.userid &&
                projectid == that.projectid &&
                Objects.equals(permissionDescription, that.permissionDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionid, userid, projectid, permissionDescription);
    }
}
