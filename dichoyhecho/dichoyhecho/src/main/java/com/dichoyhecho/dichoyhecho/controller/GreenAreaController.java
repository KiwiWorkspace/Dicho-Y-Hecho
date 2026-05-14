package com.dichoyhecho.dichoyhecho.controller;


import com.dichoyhecho.dichoyhecho.entity.GreenArea;
import com.dichoyhecho.dichoyhecho.service.GreenAreaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/areasVerdes")
public class GreenAreaController {

    private final GreenAreaService GreenAreaService;

    public GreenAreaController(GreenAreaService GreenAreaService) {
        this.GreenAreaService = GreenAreaService;
    }

    @GetMapping("/get")
    public List<GreenArea> list() {
        return GreenAreaService.list();
    }

    @GetMapping("/{id}")
    public GreenArea get(@PathVariable @Positive(message = "The id must be greater than 0") Integer id){
        return GreenAreaService.findById(id);
    }

    @PostMapping("/post")
    @ResponseStatus
    public GreenArea create(@RequestBody GreenArea areasVerdes){
        return GreenAreaService.create(areasVerdes);
    }

    @PutMapping("/put/{id}")
    public GreenArea update(@PathVariable Integer id, @Valid @RequestBody GreenArea areasVerdes){
        return GreenAreaService.update(id, areasVerdes);
    }

    @DeleteMapping("/{id}")
    public GreenArea delete(@PathVariable Integer id){
        GreenAreaService.delete(id);
        return null;
    }

    @GetMapping("/greenArea")
    public String showContact() {
        return "greenArea";
    }
}
