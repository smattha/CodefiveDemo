package com.skyroof.datatypes;

//class that returns to the back end the login details of the user
public class LoginDetails {
    String username;
    String pswd;

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
