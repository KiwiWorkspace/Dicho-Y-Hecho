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

    public LocalesController (LocalesService localesService){
        this.localesService = localesService;
    }

    @GetMapping("/get")
    public List<Locales> listar(){
        return this.localesService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Locales crear(@RequestBody Locales locales){
        return this.localesService.crear(locales);
    }

    @PutMapping("/put/{id}")
        public Locales actualizar(@PathVariable Integer id, @Valid @RequestBody Locales locales){
        return localesService.actualizar(Long.valueOf(id), locales);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        this.localesService.eliminar(id);
    }
}
