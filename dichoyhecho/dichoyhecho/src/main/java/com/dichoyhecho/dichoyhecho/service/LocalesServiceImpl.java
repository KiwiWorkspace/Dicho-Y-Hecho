package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import com.dichoyhecho.dichoyhecho.repository.LocalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalesServiceImpl implements LocalesService {

    private final LocalesRepository localesRepository;

    public LocalesServiceImpl(LocalesRepository localesRepository) {
        this.localesRepository = localesRepository;
    }

    @Override
    public List<Locales> listar() {
        return localesRepository.findAll();
    }

    @Override
    public Locales obtenerPorId(Integer id) {
        return localesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Local con ID no encontrado: " + id));
    }

    @Override
    public Locales crear(Locales locales) {
        locales.setId_locales(null);
        return localesRepository.save(locales);
    }

    @Override
    public Locales actualizar(Long id, Locales locales) {
        return null;
    }

    @Override
    public Locales actualizar(Integer id, Locales locales) {
        if (!localesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Local con ID no encontrado: " + id);
        }
        locales.setId_locales(id);
        return localesRepository.save(locales);
    }

    @Override
    public int eliminar(Integer id) {
        if (!localesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Local con ID no encontrado: " + id);
        }
        localesRepository.deleteById(id);
        return 0;
    }
}