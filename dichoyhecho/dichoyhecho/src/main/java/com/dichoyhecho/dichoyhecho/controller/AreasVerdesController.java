package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.AreasVerdes;
import com.dichoyhecho.dichoyhecho.service.AreasVerdesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/areasVerdes")
public class AreasVerdesController {

    private final AreasVerdesService areasVerdesService;

    public AreasVerdesController(AreasVerdesService areasVerdesService) {
        this.areasVerdesService = areasVerdesService;
    }

    @GetMapping("/get")
    public List<AreasVerdes> listar() {
        return areasVerdesService.listar();
    }

    @GetMapping("/{id}")
    public AreasVerdes obtener(@PathVariable Integer id){
        return areasVerdesService.buscarPorId(id);
    }

    @GetMapping("/post")
    @ResponseStatus
    public AreasVerdes crear(@RequestBody AreasVerdes areasVerdes){
        return areasVerdesService.crear(areasVerdes);
    }

    @PutMapping("/put/{id}")
    public AreasVerdes actualizar(@PathVariable Integer id, @RequestBody AreasVerdes areasVerdes){
        return areasVerdesService.actualizar(id, areasVerdes);
    }

    @DeleteMapping("/{id}")
    public AreasVerdes eliminar(@PathVariable Integer id){
        areasVerdesService.eliminar(id);
        return null;
    }




}
