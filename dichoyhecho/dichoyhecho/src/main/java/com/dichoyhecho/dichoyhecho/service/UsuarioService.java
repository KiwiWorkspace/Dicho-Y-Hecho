package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> list();
    Usuario GetById(Integer id);
    Usuario create(Usuario usuario);
    Usuario update(Integer id, Usuario usuario);
    void delete(Integer id);

}
