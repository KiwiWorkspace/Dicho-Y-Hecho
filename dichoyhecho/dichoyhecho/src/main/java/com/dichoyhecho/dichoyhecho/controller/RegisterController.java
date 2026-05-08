package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.repository.UserRepository;
import com.dichoyhecho.dichoyhecho.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    public RegisterController(UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("users", new Users());
        return "register";
    }

    @PostMapping("/enviar-registro")
    public String registrar(@ModelAttribute("users") Users users, Model model) {

        System.out.println("ENTRÓ AL POST");

        // verify  if exits in database
        if (userRepository.findByUserHandle(users.getUserHandle()).isPresent()) {
            model.addAttribute("error", "The username is already in use");
            model.addAttribute("users", users);
            return "register";
        }

        if (users.getAgeUser() < 0) {
            model.addAttribute("error", "La edad no puede ser negativa");
            return "register";
        }

        // encrypt password
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        // save to DB
        userRepository.save(users);
        emailService.sendConfirmation(users.getEmailUser());

        System.out.println("Users save DB: " + users.getUserHandle());
        System.out.println("Pasword save DB: " + users.getPassword());


        return "redirect:/login";
    }

}