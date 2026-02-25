package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listar();
    void crear(Usuario usuario);
    int actualizar(Long id, Usuario usuario);
    int eliminar(Long id);

}
