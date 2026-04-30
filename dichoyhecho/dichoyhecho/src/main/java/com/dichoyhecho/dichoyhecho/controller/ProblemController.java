package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Problems;
import com.dichoyhecho.dichoyhecho.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/problem")
public class ProblemController {

    private final ProblemService ProblemService;

    public ProblemController(ProblemService ProblemService){
        this.ProblemService = ProblemService;
    }

    @GetMapping("/get")
    public List<Problems> list(){
        return this.ProblemService.list();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Problems create(@RequestBody Problems problemas){
        return this.ProblemService.create(problemas);
    }

    @PutMapping("/update/{id}")
    public Problems update(@PathVariable Integer id,
                           @RequestBody Problems problemas){
        return this.ProblemService.update(id, problemas);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        this.ProblemService.delete(id);
    }


}
