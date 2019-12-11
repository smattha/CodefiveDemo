package com.skyroof.model.entities;

public class UserProjects {
    int projectId;
    String projectName;
    String permission;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserProjects{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
