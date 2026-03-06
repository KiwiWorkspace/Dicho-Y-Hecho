package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.ComentarioRequest;
import com.dichoyhecho.dichoyhecho.entity.Comentarios;
import com.dichoyhecho.dichoyhecho.service.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/comentarios")
public class ComentarioController {
    @Autowired
    private UsuarioServiceImpl.ComentarioService comentarioService;

    @PostMapping("/publicar")
    public ResponseEntity<?> publicarComentario(@Valid @ModelAttribute ComentarioRequest request) {
        try {
            //se pasa el objeto completo al Service
            comentarioService.guardarComentario(request);

            return ResponseEntity.ok("Comentario publicado ");
        } catch (Exception e) {
            // Por si algo falla en el parsing de los bytes de las imagenes de post
            return ResponseEntity.badRequest().body("Error al publicar: " + e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Comentarios>> listarComentarios() {
        List<Comentarios> lista = comentarioService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/eliminar/{idComentario}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long idComentario,
            @RequestParam Integer idUsuario
    ) {
        try {
            comentarioService.eliminarComentario(idComentario, idUsuario);
            return ResponseEntity.ok("Comentario eliminado..");
        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}