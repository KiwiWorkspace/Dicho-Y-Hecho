package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/profile/edit")
    public String showEditForm(Model model, Authentication authentication) {
        String currentHandle = authentication.getName();
        Users user = userService.getByHandle(currentHandle);
        model.addAttribute("user", user);
        return "profile-edit";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("user") Users updatedUser,
                                @RequestParam("profilePhoto") MultipartFile profilePhoto, // <-- Recibe el archivo del HTML
                                Model model,
                                Authentication authentication) {
        try {

            String currentHandle = authentication.getName();
            Users currentUser = userService.getByHandle(currentHandle);

            if (profilePhoto != null && !profilePhoto.isEmpty()) {
               currentUser.setProfileImg(profilePhoto.getBytes());
            }
            currentUser.setFirstName(updatedUser.getFirstName());
            currentUser.setLastName(updatedUser.getLastName());
            currentUser.setUserHandle(updatedUser.getUserHandle());
            currentUser.setAgeUser(updatedUser.getAgeUser());
            currentUser.setEmailUser(updatedUser.getEmailUser());

            userService.update(currentUser.getIdUser(), currentUser);

           return "redirect:/profile?success=true";

        } catch (Exception e) {
            model.addAttribute("error", "No se pudieron guardar los cambios o procesar la imagen.");
            model.addAttribute("user", updatedUser);
            return "profile-edit";
        }
    }
}