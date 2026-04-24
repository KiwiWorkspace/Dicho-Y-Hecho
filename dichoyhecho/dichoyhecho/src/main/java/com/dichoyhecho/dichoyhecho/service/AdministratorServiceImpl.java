package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Administrator;
import com.dichoyhecho.dichoyhecho.repository.AdministratorRepository;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    private AdministratorRepository AdministratorRepository;
    private final PasswordEncoder passwordEncoder;
    private EmailService correoService;

    public AdministratorServiceImpl(EmailService correoService, PasswordEncoder passwordEncoder, AdministratorRepository AdministratorRepository) {
        this.EmailService = correoService;
        this.passwordEncoder = passwordEncoder;
        this.AdministratorRepository = AdministratorRepository;
    }

    @Override
    public List<Administrator> list() {
        return  AdministratorRepository.findAll();
    }

    @Override
    public Administrator GetById(Integer id) {
        return AdministratorRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Administrator with ID not found: " + id));
    }

    @Override
    public Administrator create(Administrator administrator) {
        if (AdministratorRepository.existsByCorreo(administrator.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));

            Administrator guardado = AdministratorRepository.save(administrator);
            try{
                correoService.sendConfirmation(guardado.getEmail());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                
            }
            return guardado;
        }

    @Override
    public Administrator update(Integer id, Administrator administrator) {
        administrator.setid(id);
        return AdministratorRepository.save(administrator);
    }

    @Override
    public void delete(Integer id) {
        if(!AdministratorRepository.existsById(id)){
            throw new ResourceNotFound("Administrator with ID not found " + id);
        }
        AdministratorRepository.deleteById(id);
    }
}
