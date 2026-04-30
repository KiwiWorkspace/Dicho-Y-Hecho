package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> list();
    Users getById(Integer id);
    Users create(Users usuario);
    Users update(Integer id, Users usuario);
    void delete(Integer id);

}
