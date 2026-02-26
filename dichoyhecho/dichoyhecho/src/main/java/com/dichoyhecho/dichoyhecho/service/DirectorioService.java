package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;

import java.util.List;

public interface DirectorioService {

    List<Locales> listar();
    void crear(Locales locales);
    int actualizar(Long id, Locales locales);
    int eliminar(Long id);

}
