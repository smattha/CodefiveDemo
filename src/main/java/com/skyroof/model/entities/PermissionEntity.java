package com.skyroof.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permission", schema = "skyroof", catalog = "")
public class PermissionEntity {
    private int permissionId;
    private int userId;
    private int projectId;
    private String permissionDescriptionl;

    @Id
    @Column(name = "permissionID")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "permissionDescriptionl")
    public String getPermissionDescriptionl() {
        return permissionDescriptionl;
    }

    public void setPermissionDescriptionl(String permissionDescriptionl) {
        this.permissionDescriptionl = permissionDescriptionl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return permissionId == that.permissionId &&
                userId == that.userId &&
                projectId == that.projectId &&
                Objects.equals(permissionDescriptionl, that.permissionDescriptionl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, userId, projectId, permissionDescriptionl);
    }
}
