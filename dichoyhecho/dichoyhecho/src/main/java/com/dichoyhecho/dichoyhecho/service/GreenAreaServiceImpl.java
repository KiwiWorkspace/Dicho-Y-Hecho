package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.GreenArea;
import com.dichoyhecho.dichoyhecho.repository.GreenAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenAreaServiceImpl implements GreenAreaService{

    private final GreenAreaRepository GreenAreaRepository;

    public GreenAreaServiceImpl(GreenAreaRepository GreenAreaRepository) {
        this.GreenAreaRepository = GreenAreaRepository;
    }

    @Override
    public List<GreenArea> list() {
        return GreenAreaRepository.findAll();
    }

    @Override
    public GreenArea findById(Integer id) {
        return GreenAreaRepository.findById(id).orElseThrow(() -> new RuntimeException("Green area with ID not found: " + id));
    }

    @Override
    public GreenArea create(GreenArea areasVerdes) {
        return GreenAreaRepository.save(areasVerdes);
    }

    @Override
    public GreenArea update(Integer id, GreenArea areasVerdes) {
        GreenArea existente = findById(id);
        existente.setAreaStatus(areasVerdes.getAreaStatus());
        existente.setAreaName(areasVerdes.getAreaName());
        existente.setAreaType(areasVerdes.getAreaType());
        existente.setAreaLocation(areasVerdes.getAreaLocation());
        return GreenAreaRepository.save(existente);
    }

    @Override
    public void delete(Integer id) {
        GreenArea existente = findById(id);
        GreenAreaRepository.delete(existente);
    }
}