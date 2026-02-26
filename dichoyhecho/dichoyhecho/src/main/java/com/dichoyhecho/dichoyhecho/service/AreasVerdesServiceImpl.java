package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.AreasVerdes;
import com.dichoyhecho.dichoyhecho.repository.AreasVerdesRepository;

import java.util.List;

public class AreasVerdesServiceImpl implements AreasVerdesService{



    //instancia y constructor de areasVerdesService para poder usar sus metodos
    private final AreasVerdesRepository areasVerdesRepository;

    public AreasVerdesServiceImpl(AreasVerdesRepository areasVerdesRepository) {
        this.areasVerdesRepository = areasVerdesRepository;
    }



    //Se usa override por que son metodos sobreescritos
    @Override
    public List<AreasVerdes> listar() {
        return areasVerdesRepository.findAll();
    }

    @Override
    public AreasVerdes buscarPorId(Integer id) {
        return areasVerdesRepository.findById(id).orElseThrow(()-> new RuntimeException("Srea verde con ID no encontrada: " + id));
    }

    @Override
    public AreasVerdes crear(AreasVerdes areasVerdes) {
        areasVerdes.setEstado_area(null);
        return areasVerdesRepository.save(areasVerdes);
    }

    @Override
    public AreasVerdes actualizar(Integer id, AreasVerdes areasVerdes) {
        AreasVerdes existente = buscarPorId(id);
        existente.setEstado_area(areasVerdes.getEstado_area());
        existente.setNombre_area(areasVerdes.getNombre_area());
        existente.setTipo_area(areasVerdes.getTipo_area());
        existente.setUbicacion_area(areasVerdes.getUbicacion_area());

        return areasVerdesRepository.save(existente) ;
    }

    @Override
    public void eliminar(Integer id) {
        AreasVerdes existente = buscarPorId(id);
        areasVerdesRepository.delete(existente);
    }
}
