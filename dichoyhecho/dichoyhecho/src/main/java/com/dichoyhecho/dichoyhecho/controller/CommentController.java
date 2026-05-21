package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.service.CommentService;
import com.dichoyhecho.dichoyhecho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/publicar")
    public String publicar(@RequestParam("content") String content,
                           @RequestParam("idZone") Integer idZone,
                           @RequestParam(value = "fileAttached", required = false) MultipartFile file,
                           Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        Users user = userService.getByHandle(authentication.getName());
        if (user == null) {
            return "redirect:/home?error=UserNotFound";
        }

        commentService.save(content, idZone, user, file);

        return "redirect:/zona/" + idZone;
    }

    @PostMapping("/comment/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         @RequestParam(value = "zona", required = false) Integer zona,
                         Authentication authentication) {

        Users userActual = userService.getByHandle(authentication.getName());
        try {
            commentService.eliminarComentario(id, userActual.getIdUser().intValue());
            return (zona != null) ? "redirect:/zona/" + zona : "redirect:/home";
        } catch (RuntimeException e) {
            return "redirect:/home?error=forbidden";
        }
    }
    @PostMapping("/comment/update/{id}")
    public String updateComment(@PathVariable Long id,
                                @RequestParam("content") String newContent,
                                Authentication authentication) {

        Users userActual = userService.getByHandle(authentication.getName());
        Comments comment = commentService.findById(id.intValue());

        if (comment.getIdUser().getIdUser().equals(userActual.getIdUser())) {
            comment.setContent(newContent);
            commentService.update(id.intValue(), comment);
        }

        return "redirect:/zona/" + comment.getIdZone();
    }
}