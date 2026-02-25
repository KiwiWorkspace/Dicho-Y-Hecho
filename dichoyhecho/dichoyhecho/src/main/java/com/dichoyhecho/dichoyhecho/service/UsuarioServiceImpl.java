package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Override
    public List<Usuario> listar() {
        return List.of();
    }

    @Override
    public void crear(Usuario usuario) {

    }

    @Override
    public int actualizar(Long id, Usuario usuario) {
        return 0;
    }

    @Override
    public int eliminar(Long id) {
        return 0;
    }
}
