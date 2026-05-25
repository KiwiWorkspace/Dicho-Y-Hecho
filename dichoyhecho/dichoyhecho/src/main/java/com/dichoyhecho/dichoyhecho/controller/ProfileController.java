package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.service.CommentService;
import com.dichoyhecho.dichoyhecho.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    private final UserService userService;
    private final CommentService commentService;

    public ProfileController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication authentication) {
        String currentHandle = authentication.getName();
        Users user = userService.getByHandle(currentHandle);
        model.addAttribute("user", user);
        // See the comments in the profile
        List<Comments> allComments = commentService.findByUserId(user.getIdUser());
        List<Comments> activityProfile = allComments.stream()
                .sorted((firstComment, secondComment) -> secondComment.getCommentDate()
                        .compareTo(firstComment.getCommentDate()))
                .limit(5).toList();

        model.addAttribute("myComments", activityProfile);
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
                                @RequestParam("profilePhoto") MultipartFile profilePhoto,
                                Model model,
                                Authentication authentication) {
        try {
            String currentHandle = authentication.getName();
            // verify if username already exists
            Users currentUser = userService.getByHandle(currentHandle);

            if (!updatedUser.getUserHandle().equals(currentUser.getUserHandle())) {

                Users existente = null;
                try {
                    existente = userService.getByHandle(updatedUser.getUserHandle());
                } catch (Exception e){

                }

                if (existente != null) {
                    model.addAttribute("error", "the username:  @" + updatedUser.getUserHandle() + " already exist");
                    model.addAttribute("user", currentUser);
                    return "profile-edit";
                }
            }
            if (profilePhoto != null && !profilePhoto.isEmpty()) {
                currentUser.setProfileImg(profilePhoto.getBytes());
            }

            currentUser.setFirstName(updatedUser.getFirstName());
            currentUser.setLastName(updatedUser.getLastName());
            currentUser.setUserHandle(updatedUser.getUserHandle());
            currentUser.setAgeUser(updatedUser.getAgeUser());
            currentUser.setEmailUser(updatedUser.getEmailUser());

            userService.update(currentUser.getIdUser(), currentUser);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            List<GrantedAuthority> authorities = new ArrayList<>(auth.getAuthorities());
            UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(
                    updatedUser.getUserHandle(),
                    auth.getCredentials(),
                    authorities
            );
            SecurityContextHolder.getContext().setAuthentication(newAuth);
            return "redirect:/profile?success=true";

        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
            model.addAttribute("user", updatedUser);
            return "profile-edit";
        }
    }
}