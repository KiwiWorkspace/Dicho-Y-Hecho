package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Store;
import com.dichoyhecho.dichoyhecho.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/locales")
public class StoreController {

    private final StoreService StoreService;

    public StoreController(StoreService StoreService) {
        this.StoreService = StoreService;
    }

    @GetMapping("/get")
    public List<Store> list() {
        return this.StoreService.list();
    }

    @GetMapping("/{id}")
    public Store GetById(@PathVariable Integer id) {
        return this.StoreService.GetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store create(@Valid @RequestBody Store locales) {
        return this.StoreService.create(locales);
    }

    @PutMapping("/{id}")
    public Store update(@PathVariable Integer id, @Valid @RequestBody Store locales) {
        return StoreService.update(id, locales);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.StoreService.delete(id);
    }
}