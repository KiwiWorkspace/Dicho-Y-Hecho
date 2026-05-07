package com.dichoyhecho.dichoyhecho.controller;
/*
import com.dichoyhecho.dichoyhecho.dto.LoginUserRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUserResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUserRequest;
import com.dichoyhecho.dichoyhecho.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }


}

 */

