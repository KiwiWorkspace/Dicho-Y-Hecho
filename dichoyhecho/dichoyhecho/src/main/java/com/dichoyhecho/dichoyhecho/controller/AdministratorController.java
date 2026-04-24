package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Administrator;
import com.dichoyhecho.dichoyhecho.service.AdministratorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/admin")
public class AdministratorController {

    private final AdministratorService AdministratorService;

    public AdministratorController(AdministratorService AdministratorService) {
        this.AdministratorService = AdministratorService;
    }

    @RequestMapping("/get")
    public List<Administrator> list() {
        return this.AdministratorService.list();
    }

    @RequestMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Administrator create(@RequestBody Administrator administrator) {
        return this.AdministratorService.create(administrator);
    }


    @PutMapping("/update/{id}")
    public Administrator update (@PathVariable Integer id,
                                     @RequestBody Administrator administrator) {
        return this.AdministratorService.update(id, administrator);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.AdministratorService.delete(id);
    }

}
