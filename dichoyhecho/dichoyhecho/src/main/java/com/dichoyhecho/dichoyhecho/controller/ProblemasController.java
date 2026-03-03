package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Problemas;
import com.dichoyhecho.dichoyhecho.service.ProblemasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/problem")
public class ProblemasController {

    private final ProblemasService problemasService;

    public ProblemasController(ProblemasService problemasService){
        this.problemasService = problemasService;
    }

    @GetMapping("/get")
    public List<Problemas> listar(){
        return this.problemasService.listar();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Problemas crear(@RequestBody Problemas problemas){
        return this.problemasService.crear(problemas);
    }

    @PutMapping("/update/{id}")
    public Problemas actualizar(@PathVariable Integer id,
                                  @RequestBody Problemas problemas){
        return this.problemasService.actualizar(id, problemas);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        this.problemasService.eliminar(id);
    }


}
