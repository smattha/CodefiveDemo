package com.skyroof.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PermissionEntityPK implements Serializable {
    private int permissionId;
    private int userId;
    private int projectId;

    @Column(name = "permissionID")
    @Id
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Column(name = "userID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "projectID")
    @Id
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntityPK that = (PermissionEntityPK) o;
        return permissionId == that.permissionId &&
                userId == that.userId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, userId, projectId);
    }
}
