package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Admins;
import com.dichoyhecho.dichoyhecho.service.AdministratorService;
import org.springframework.http.HttpStatus;
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
    public List<Admins> list() {
        return this.AdministratorService.list();
    }

    @RequestMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Admins create(@RequestBody Admins admins) {
        return this.AdministratorService.create(admins);
    }


    @PutMapping("/update/{id}")
    public Admins update (@PathVariable Integer id,
                          @RequestBody Admins admins) {
        return this.AdministratorService.update(id, admins);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.AdministratorService.delete(id);
    }

}
