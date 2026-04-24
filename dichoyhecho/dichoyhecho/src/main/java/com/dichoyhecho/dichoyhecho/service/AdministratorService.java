package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdministratorService {

    List<Administrator> list();
    Administrator GetById(Integer id);
    Administrator create(Administrator administrator);
    Administrator update(Integer id, Administrator administrator);
    void delete(Integer id);
}
