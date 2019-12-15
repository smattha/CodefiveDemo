package com.skyroof.datatypes;

//custom class created to return to the front end just the Project ID, the Project Name and the permission of the logged in user
public class UserProjects {
    private int projectId;
    private String projectName;
    private String permission;

    public UserProjects() {
    }

    public UserProjects(int projectId, String projectName, String permission) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.permission = permission;
    }

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
