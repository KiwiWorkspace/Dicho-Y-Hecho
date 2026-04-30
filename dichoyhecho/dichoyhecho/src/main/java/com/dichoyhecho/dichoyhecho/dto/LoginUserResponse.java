package com.dichoyhecho.dichoyhecho.dto;

public class LoginUserResponse {

    public String message;
    public long usuarioId;
    public String name;
    public String email;
    public String password;


    public LoginUserResponse(String message, long usuarioId, String name, String email, String password) {
        this.message = message;
        this.usuarioId = usuarioId;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public LoginUserResponse(String message, long usuarioId , String name, String email) {
        this.message = message;
        this.usuarioId = usuarioId;
        this.email = email;
        this.name = name;
        this.email = email;
    }

    public LoginUserResponse() {
    }
}

