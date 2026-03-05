package com.dichoyhecho.dichoyhecho.service;


import com.dichoyhecho.dichoyhecho.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AutenService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
}
