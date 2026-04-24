package com.dichoyhecho.dichoyhecho.controller;

import ch.qos.logback.core.util.ReentryGuard;
import com.dichoyhecho.dichoyhecho.dto.LoginRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterRequest;
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
    public void register(@Valid @RequestBody RegisterRequest req) {
        authService.register(req);
        System.out.println("User registered successfully.");
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        return authService.login(req);
    }
}
