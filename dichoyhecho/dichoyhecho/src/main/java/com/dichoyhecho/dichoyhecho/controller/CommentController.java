package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comments;
import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.repository.CommentRepository;
import com.dichoyhecho.dichoyhecho.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @GetMapping("/comment")
    public String ShowComments(){
        return "comment";
    }

    @Autowired
    private UserServiceImpl.CommentService commentService;

    @PostMapping("/publicar")
    public ResponseEntity<?> publicarComentario(@Valid @ModelAttribute CommentRequest request) {
        try {
            //object is recived by the Service
            commentService.guardarComentario(request);

            return ResponseEntity.ok("Comment published ");
        } catch (Exception e) {
            // Por si algo falla en el parsing de los bytes de las imagenes de post
            return ResponseEntity.badRequest().body("Error publishing: " + e.getMessage());
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Comments>> listarComentarios() {
        List<Comments> lista = commentService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(
            @PathVariable Long commentId,
            @RequestParam Integer userId
    ) {
        try {
            commentService.eliminarComentario(commentId, userId);
            return ResponseEntity.ok("Comment deleted.");
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}