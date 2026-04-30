package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.entity.Users;
import com.dichoyhecho.dichoyhecho.service.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<Users> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public Users get(@PathVariable @Min(value = 1, message = "the value must be greater than 1") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
        return userService.create(users);
    }

    @PutMapping("/{id}")
    public Users update(@PathVariable Integer id, @RequestBody Users users) {
        return userService.update(id, users);
    }

    @DeleteMapping("/{id}")
    public Users delete(@PathVariable Integer id) {
        userService.delete(id);
        return null;
    }
}