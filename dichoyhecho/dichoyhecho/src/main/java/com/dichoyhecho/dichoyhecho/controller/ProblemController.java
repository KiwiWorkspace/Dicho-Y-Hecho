package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.Problem;
import com.dichoyhecho.dichoyhecho.service.ProblemService;
import jakarta.validation.Valid;
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
    public List<Problem> list(){
        return this.ProblemService.list();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Problem create(@RequestBody Problem problemas){
        return this.ProblemService.create(problemas);
    }

    @PutMapping("/update/{id}")
    public Problem update(@PathVariable Integer id,
                                    @RequestBody Problem problemas){
        return this.ProblemService.update(id, problemas);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        this.ProblemService.delete(id);
    }


}
