package com.dichoyhecho.dichoyhecho.service;


import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUsuarioRequest;
import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
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
    public void register (RegisterUsuarioRequest req) {
        if (userRepository.existsByEmailUsuario(req.email)) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        String hash = passwordEncoder.encode(req.password);
        Usuario user = new Usuario(
                req.name,
                req.apellido,
                hash,
                req.handle,
                req.email,
                req.edad,
                null);
        userRepository.save(user);
    }

    public LoginUsuarioResponse login (LoginUsuarioRequest req) {
        Usuario user = userRepository.findByEmailUsuario(req.email)
                .orElseThrow(() -> new IllegalArgumentException("Email Incorrecto o no existe."));

        boolean ok = passwordEncoder.matches(req.password, user.getContrasena());
        if (!ok) throw new IllegalArgumentException("Contraseña incorrecta");
        return new LoginUsuarioResponse("Login correcto: ",user.getIdUsuario(), user.getNombreUsuario(), user.getEmailUsuario());
    }

}
