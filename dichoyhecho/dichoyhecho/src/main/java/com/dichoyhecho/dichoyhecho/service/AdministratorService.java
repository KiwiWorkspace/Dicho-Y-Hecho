package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Admins;

import java.util.List;

public interface AdministratorService {

    List<Admins> list();
    Admins GetById(Integer id);
    Admins create(Admins admins);
    Admins update(Integer id, Admins admins);
    void delete(Integer id);
}