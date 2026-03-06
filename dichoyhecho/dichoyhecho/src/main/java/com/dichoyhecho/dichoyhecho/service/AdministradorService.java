package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrador;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdministradorService {

    List<Administrador> listar();
    Administrador obtenerPorId(Integer id);
    Administrador crear(Administrador administrador);
    Administrador actualizar(Integer id, Administrador administrador);
    void eliminar(Integer id);
}
