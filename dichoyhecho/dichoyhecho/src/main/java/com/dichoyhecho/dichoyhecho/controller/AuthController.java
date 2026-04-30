package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.LoginUserRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUserResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUserRequest;
import com.dichoyhecho.dichoyhecho.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dichoyhecho/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterUserRequest req) {
        authService.register(req);
        System.out.println("User registered successfully.");
    }

    @PostMapping("/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest req) {
        return authService.login(req);
    }
}
