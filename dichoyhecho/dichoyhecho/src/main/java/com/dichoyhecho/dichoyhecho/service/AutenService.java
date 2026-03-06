package com.dichoyhecho.dichoyhecho.service;


import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUsuarioResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUsuarioRequest;
import com.dichoyhecho.dichoyhecho.entity.Administrador;
import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
import com.dichoyhecho.dichoyhecho.repository.AdministradorRepository;
import com.dichoyhecho.dichoyhecho.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenService implements UserDetailsService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AdministradorRepository administradorRepository;

    public AutenService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AdministradorRepository administradorRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.administradorRepository = administradorRepository;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = userRepository.findByEmailUsuario(email).orElse(null);

        if (user != null) {
            return User.builder()
                    .username(user.getEmailUsuario())
                    .password(user.getContrasena())
                    .roles("USER")
                    .build();
        }

        Administrador admin = administradorRepository.findByCorreo(email).orElse(null);

        if (admin != null) {
            return User.builder()
                    .username(admin.getCorreo())
                    .password(admin.getContrasena())
                    .roles("ADMIN")
                    .build();
        }

        throw new UsernameNotFoundException("Usuario no encontrado");
    }

}
