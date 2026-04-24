package com.dichoyhecho.dichoyhecho.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

        @Email
        @NotBlank
        public String email;

        @NotBlank
        public String password;
    }
