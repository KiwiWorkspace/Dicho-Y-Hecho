package com.dichoyhecho.dichoyhecho.dto;

import org.jspecify.annotations.Nullable;

public class LoginUsuarioResponse {
    public String message;
    public long usuarioId;
    public String name;
    public String email;
    public String password;


    public LoginUsuarioResponse(String message, long usuarioId, String name, String email, String password) {
        this.message = message;
        this.usuarioId = usuarioId;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public LoginUsuarioResponse(String message, long usuarioId , String name, String email) {
        this.message = message;
        this.usuarioId = usuarioId;
        this.email = email;
        this.name = name;
        this.email = email;
    }

    public LoginUsuarioResponse() {
    }
}