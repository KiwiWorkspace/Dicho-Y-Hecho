package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Locales;
import com.dichoyhecho.dichoyhecho.service.LocalesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/locales")
public class LocalesController {

    private final LocalesService localesService;

    public LocalesController(LocalesService localesService) {
        this.localesService = localesService;
    }

    @GetMapping("/get")
    public List<Locales> listar() {
        return this.localesService.listar();
    }

    @GetMapping("/{id}")
    public Locales obtenerPorId(@PathVariable Integer id) {
        return this.localesService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locales crear(@Valid @RequestBody Locales locales) {
        return this.localesService.crear(locales);
    }

    @PutMapping("/{id}")
    public Locales actualizar(@PathVariable Integer id, @Valid @RequestBody Locales locales) {
        return localesService.actualizar(id, locales);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        this.localesService.eliminar(id);
    }
}