package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.service.UsuarioService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/get")
    public List<Usuario> listar(){
        return usuarioService.listar();
    }
    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable @Min(value = 1, message = "El valor debe ser mayor a 1")Integer id){
        return usuarioService.obtenerPorId(id);
    }
    @GetMapping("/post")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.crear(usuario);
    }
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        return usuarioService.actualizar(id, usuario);
    }
    @DeleteMapping("/{id}")
    public Usuario eliminar (Integer id){
        usuarioService.eliminar(id);
        return null;
    }
}
