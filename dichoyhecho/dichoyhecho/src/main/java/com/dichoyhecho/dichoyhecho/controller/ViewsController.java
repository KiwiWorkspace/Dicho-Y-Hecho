package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Problems;
import com.dichoyhecho.dichoyhecho.enums.ProblemStatus;
import com.dichoyhecho.dichoyhecho.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/problems")
public class ViewsController {

    private final ProblemService problemService;

    public ViewsController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("problem", new Problems());
        return "problem-form";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Problems problem, Model model) {
        problem.setStatus(ProblemStatus.REPORTED);
        problemService.create(problem);
        model.addAttribute("mensaje", "¡Solicitud enviada! Un administrador revisará tu petición.");
        return "problem-form";
    }
}