package com.dichoyhecho.dichoyhecho.dto;

public class LoginResponse {

    private String message;
    private long userId;
    private String name;
    private String email;
    private String password;

    public LoginResponse(String message, long userId, String name, String email, String password) {
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public LoginResponse(String message, long userId, String name, String email) {
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public LoginResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}