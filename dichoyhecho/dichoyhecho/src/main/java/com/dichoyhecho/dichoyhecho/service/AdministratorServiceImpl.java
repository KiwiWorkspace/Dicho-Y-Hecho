package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Admins;
import com.dichoyhecho.dichoyhecho.repository.AdminRepository;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService{

    private AdminRepository AdminRepository;
    private final PasswordEncoder passwordEncoder;
    private EmailService correoService;

    public AdministratorServiceImpl(EmailService correoService, PasswordEncoder passwordEncoder, AdminRepository AdminRepository) {
        this.correoService = correoService;
        this.passwordEncoder = passwordEncoder;
        this.AdminRepository = AdminRepository;
    }

    @Override
    public List<Admins> list() {
        return  AdminRepository.findAll();
    }

    @Override
    public Admins GetById(Integer id) {
        return AdminRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Administrator with ID not found: " + id));
    }

    @Override
    public Admins create(Admins admins) {
        if (AdminRepository.existsByEmail(admins.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        admins.setPassword(passwordEncoder.encode(admins.getPassword()));

        Admins guardado = AdminRepository.save(admins);
        try{
            correoService.sendConfirmation(guardado.getEmail());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return guardado;
    }

    @Override
    public Admins update(Integer id, Admins admins) {
        admins.setId(id);
        return AdminRepository.save(admins);
    }

    @Override
    public void delete(Integer id) {
        if(!AdminRepository.existsById(id)){
            throw new ResourceNotFound("Administrator with ID not found " + id);
        }
        AdminRepository.deleteById(id);
    }
}