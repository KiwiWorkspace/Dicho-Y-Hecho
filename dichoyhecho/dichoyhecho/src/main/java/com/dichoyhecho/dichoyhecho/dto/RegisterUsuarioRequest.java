package com.dichoyhecho.dichoyhecho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public class RegisterUsuarioRequest {
    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String password;

}
