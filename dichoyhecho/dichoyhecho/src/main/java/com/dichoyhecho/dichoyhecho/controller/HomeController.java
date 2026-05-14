package com.dichoyhecho.dichoyhecho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("/zona-1")
    public String zone(Model model, Principal zone1) {
        model.addAttribute("username", zone1.getName());
        return "zona-1";
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

}
