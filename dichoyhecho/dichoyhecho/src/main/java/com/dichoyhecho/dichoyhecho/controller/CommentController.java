package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.CommentRequest;
import com.dichoyhecho.dichoyhecho.entity.Comment;
import com.dichoyhecho.dichoyhecho.service.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/comentarios")
public class CommentController {
    @Autowired
    private UsuarioServiceImpl.ComentarioService comentarioService;

    @PostMapping("/publicar")
    public ResponseEntity<?> publicarComentario(@Valid @ModelAttribute CommentRequest request) {
        try {
            //object is recived by the Service
            comentarioService.guardarComentario(request);

            return ResponseEntity.ok("Comment published ");
        } catch (Exception e) {
            // Por si algo falla en el parsing de los bytes de las imagenes de post
            return ResponseEntity.badRequest().body("Error publishing: " + e.getMessage());
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Comment>> listarComentarios() {
        List<Comment> lista = comentarioService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> delete(
            @PathVariable Long commentId,
            @RequestParam Integer userId
    ) {
        try {
            comentarioService.eliminarComentario(commentId, userId);
            return ResponseEntity.ok("Comment deleted.");
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}