package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorioServicesImpl implements DirectorioService{
    @Override
    public List<Locales> listar() {
        return List.of();
    }

    @Override
    public void crear(Locales locales) {

    }

    @Override
    public int actualizar(Long id, Locales locales) {
        return 0;
    }

    @Override
    public int eliminar(Long id) {
        return 0;
    }
}
