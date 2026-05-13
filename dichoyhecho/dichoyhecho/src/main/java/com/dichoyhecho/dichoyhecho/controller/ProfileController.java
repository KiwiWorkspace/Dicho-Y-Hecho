package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
            this.userService = userService;
        }

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication authentication) {

        String currentHandle = authentication.getName();

        Users user = userService.getByHandle(currentHandle);

        model.addAttribute("user", user);

        return "profile";
        }
    }