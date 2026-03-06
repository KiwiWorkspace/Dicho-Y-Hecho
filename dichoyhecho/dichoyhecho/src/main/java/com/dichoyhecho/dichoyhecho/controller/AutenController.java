package com.dichoyhecho.dichoyhecho.controller;

import ch.qos.logback.core.util.ReentryGuard;
import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUsuarioRequest;
import com.dichoyhecho.dichoyhecho.service.AutenService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dichoyhecho/auth")
public class AutenController {
    private final AutenService autenService;

    public AutenController(AutenService autenService) {
        this.autenService = autenService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterUsuarioRequest req) {
        autenService.register(req);
        return "Usuario registrado correctamente.";
    }

    @PostMapping("/login")
    public LoginUsuarioResponse login(@Valid @RequestBody LoginUsuarioRequest req) {
        return autenService.login(req);
    }
}

