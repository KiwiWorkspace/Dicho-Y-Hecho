package com.dichoyhecho.dichoyhecho.dto;

import jakarta.validation.constraints.*;

public class RegisterUsuarioRequest {
    @NotBlank
    public String name;

    @NotBlank
    public String apellido;

    @NotBlank
    public String handle;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    @Size(min = 8, max = 12)
    public String password;

    @NotNull
    @Min(3)
    public Integer edad;
}
