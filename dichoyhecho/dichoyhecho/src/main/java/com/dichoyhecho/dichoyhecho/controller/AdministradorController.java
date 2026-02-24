package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Administrador;
import com.dichoyhecho.dichoyhecho.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/admin")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @RequestMapping("/get")
    public List<Administrador> listar() {
        return this.administradorService.listar();
    }

    @RequestMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Administrador crear(@Valid @RequestBody Administrador propietario) {
        return this.administradorService.crear(propietario);
    }

    @PutMapping("/update/{id}")
    public Administrador actualizar(@Valid @PathVariable Integer id, @RequestBody Administrador administrador) {
        return this.administradorService.actualizar(id, administrador);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@Valid @PathVariable Integer id) {
        this.administradorService.eliminar(id);
    }

}
