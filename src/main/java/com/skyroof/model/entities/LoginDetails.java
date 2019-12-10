package com.skyroof.model.entities;

public class LoginDetails {
    private String username;
    private String pswd;

    public LoginDetails() {
    }

    public LoginDetails(String username, String pswd) {
        this.username = username;
        this.pswd = pswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "username='" + username + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
}
