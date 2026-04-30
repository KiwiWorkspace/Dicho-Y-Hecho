package com.dichoyhecho.dichoyhecho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUserRequest {

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String password;
}
