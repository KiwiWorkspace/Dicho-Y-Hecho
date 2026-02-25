package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Directorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorioServicesImpl implements DirectorioService{
    @Override
    public List<Directorio> listar() {
        return List.of();
    }

    @Override
    public void crear(Directorio directorio) {

    }

    @Override
    public int actualizar(Long id, Directorio directorio) {
        return 0;
    }

    @Override
    public int eliminar(Long id) {
        return 0;
    }
}
