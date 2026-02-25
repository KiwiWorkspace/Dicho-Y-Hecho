package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrador;
import com.dichoyhecho.dichoyhecho.entity.Problemas;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import com.dichoyhecho.dichoyhecho.repository.ProblemasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemasServiceImpl implements ProblemasService {

    private ProblemasRepository problemasRepository;

    public ProblemasServiceImpl(ProblemasRepository problemasRepository) {
        this.problemasRepository = problemasRepository;
    }

    @Override
    public List<Problemas> listar() {
        return problemasRepository.findAll();
    }

    @Override
    public Problemas obtenerPorId(Integer id) {
        return problemasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Problema con ID no encontrado: " + id));
    }

    @Override
    public Problemas crear(Problemas problemas) {
        problemas.setId_problema(null);
        return problemasRepository.save(problemas);
    }

    @Override
    public Problemas actualizar(Integer id, Problemas problemas) {
        problemas.setId_problema(id);
        return problemasRepository.save(problemas);
    }

    @Override
    public void eliminar(Integer id) {
        if(!problemasRepository.existsById(id)){
            throw new ResourceNotFoundException("Problema con ID no encontrado " + id);
        }
        problemasRepository.deleteById(id);
    }
}
