package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrador;
import com.dichoyhecho.dichoyhecho.repository.AdministradorRepository;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService{

    private AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public List<Administrador> listar() {
        return  administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerPorId(Integer id) {
        return administradorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario con ID no encontrado: " + id));
    }


    @Override
    public Administrador crear(Administrador administrador) {
        administrador.setIdAdministrador(null);
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizar(Integer id, Administrador administrador) {
        administrador.setIdAdministrador(id);
        return administradorRepository.save(administrador);
    }

    @Override
    public void eliminar(Integer id) {
        if(!administradorRepository.existsById(id)){
            throw new ResourceNotFoundException("usuario con ID no encontrado " + id);
        }
        administradorRepository.deleteById(id);
    }
}
