package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Problemas;
import com.dichoyhecho.dichoyhecho.service.ProblemasService;
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

    @RequestMapping("/get")
    public List<Problemas> listar(){
        return this.problemasService.listar();
    }

    @RequestMapping("/post")
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
