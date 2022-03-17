package com.example.songr.domain;

public class hello {
    private String userName;
    private String password;

    public hello(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
