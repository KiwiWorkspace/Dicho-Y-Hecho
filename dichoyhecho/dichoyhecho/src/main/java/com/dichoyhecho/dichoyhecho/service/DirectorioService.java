package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Directorio;

import java.util.List;
import java.util.Optional;

public interface DirectorioService {

    List<Directorio> listar();
    void crear(Directorio directorio);
    int actualizar(Long id, Directorio directorio);
    int eliminar(Long id);

}
