package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Store;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import com.dichoyhecho.dichoyhecho.repository.StoreRepository;
import com.dichoyhecho.dichoyhecho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal !=null) {
            Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);
            model.addAttribute("user", user);
            model.addAttribute("username", principal.getName());
        }

        List<Comments> recentComments = commentRepository.findAllByOrderByCommentDateDesc();
        model.addAttribute("recentComments", recentComments.stream().limit(5).toList());

        return "home";
    }

    @GetMapping("/zona/{id}")
    public String verZona(@PathVariable("id") Integer id, Model model, Principal principal) {
        Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);
        model.addAttribute("user", user);

        model.addAttribute("username", principal.getName());
        List<Comments> comentarios = commentRepository.findByIdZoneOrderByCommentDateAsc(id);
        model.addAttribute("allComments", comentarios);
        model.addAttribute("zonaActual", id);
        return "home";
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/marketplace")
    public String marketplace(Model model, Principal principal) {
        if (principal != null) {
            Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);
            model.addAttribute("user", user);
        }
        return "marketplace";
    }

    @GetMapping("/store/register")
    public String storeRegister(Model model, Principal principal) {
        if (principal != null) {
            Users user = userRepository.findByUserHandle(principal.getName()).orElse(null);
            model.addAttribute("user", user);
        }
        model.addAttribute("store", new Store());
        return "store-register";
    }

    @PostMapping("/store/register")
    public String storeRegisterSubmit(@ModelAttribute Store store, Model model) {
        store.setStatus(com.dichoyhecho.dichoyhecho.enums.StoreStatus.PENDING);
        storeRepository.save(store);
        model.addAttribute("success", true);
        return "store-register";
    }
}