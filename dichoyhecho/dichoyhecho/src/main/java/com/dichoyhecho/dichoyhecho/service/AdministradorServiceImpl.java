package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrador;
import com.dichoyhecho.dichoyhecho.repository.AdministradorRepository;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService{

    private AdministradorRepository administradorRepository;

    private CorreoService correoService;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository, CorreoService correoService) {
        this.administradorRepository = administradorRepository;
        this.correoService = correoService;
    }

    @Override
    public List<Administrador> listar() {
        return  administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerPorId(Integer id) {
        return administradorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Administrador con ID no encontrado: " + id));
    }

    @Override
    public Administrador crear(Administrador administrador) {
            Administrador guardado = administradorRepository.save(administrador);
            try{
                correoService.enviarConfirmacion(guardado.getCorreo());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                
            }
            return guardado;
        }

    @Override
    public Administrador actualizar(Integer id, Administrador administrador) {
        administrador.setIdAdministrador(id);
        return administradorRepository.save(administrador);
    }

    @Override
    public void eliminar(Integer id) {
        if(!administradorRepository.existsById(id)){
            throw new ResourceNotFoundException("Administrador con ID no encontrado " + id);
        }
        administradorRepository.deleteById(id);
    }
}
