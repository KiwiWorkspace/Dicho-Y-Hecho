package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.AreasVerdes;
import com.dichoyhecho.dichoyhecho.repository.AreasVerdesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasVerdesServiceImpl implements AreasVerdesService{

    private final AreasVerdesRepository areasVerdesRepository;

    public AreasVerdesServiceImpl(AreasVerdesRepository areasVerdesRepository) {
        this.areasVerdesRepository = areasVerdesRepository;
    }

    @Override
    public List<AreasVerdes> listar() {
        return areasVerdesRepository.findAll();
    }

    @Override
    public AreasVerdes buscarPorId(Integer id) {
        return areasVerdesRepository.findById(id).orElseThrow(() -> new RuntimeException("Area verde con ID no encontrada: " + id));
    }

    @Override
    public AreasVerdes crear(AreasVerdes areasVerdes) {
        return areasVerdesRepository.save(areasVerdes);
    }

    @Override
    public AreasVerdes actualizar(Integer id, AreasVerdes areasVerdes) {
        AreasVerdes existente = buscarPorId(id);
        existente.setEstadoArea(areasVerdes.getEstadoArea());
        existente.setNombreArea(areasVerdes.getNombreArea());
        existente.setTipoArea(areasVerdes.getTipoArea());
        existente.setUbicacionArea(areasVerdes.getUbicacionArea());
        return areasVerdesRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        AreasVerdes existente = buscarPorId(id);
        areasVerdesRepository.delete(existente);
    }
}