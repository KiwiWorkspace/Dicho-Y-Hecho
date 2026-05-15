package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import com.dichoyhecho.dichoyhecho.service.UserService;
import com.dichoyhecho.dichoyhecho.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {


    @Autowired
    private UserServiceImpl.CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/comment")
    public String ShowComments(){
        return "comment";
    }

    @PostMapping("/publicar")
    public String publicar(@RequestParam("content") String content,
                           @RequestParam("idZone") Integer idZone,
                           Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        Users user = userService.getByHandle(authentication.getName());

        if (user == null) {

            return "redirect:/home?error=UserNotFound";
        }

        commentService.save(content, idZone, user);

        return "redirect:/zona/" + idZone;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Comments>> listarComentarios() {
        List<Comments> lista = commentService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/delete/{commentId}")
    public String delete(@PathVariable Long commentId, Authentication authentication) {
        Users userActual = userService.getByHandle(authentication.getName());
        try {
            commentService.eliminarComentario(commentId, userActual.getIdUser());
            return "redirect:/home?success=deleted";
        } catch (RuntimeException e) {

            return "redirect:/home?error=forbidden";
        }
    }
}