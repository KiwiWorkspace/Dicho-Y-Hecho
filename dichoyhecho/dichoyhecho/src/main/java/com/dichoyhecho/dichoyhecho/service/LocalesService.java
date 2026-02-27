package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;

import java.util.List;

public interface LocalesService {

    List<Locales> listar();

    Locales obtenerPorId(Integer id);

    Locales crear(Locales locales);
    Locales actualizar(Long id, Locales locales);

    Locales actualizar(Integer id, Locales locales);

    int eliminar(Integer id);

}
