package com.dichoyhecho.dichoyhecho.service;


import com.dichoyhecho.dichoyhecho.dto.LoginRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterRequest;
import com.dichoyhecho.dichoyhecho.entity.Administrator;
import com.dichoyhecho.dichoyhecho.entity.Usuario;
import com.dichoyhecho.dichoyhecho.enums.UserRole;
import com.dichoyhecho.dichoyhecho.repository.AdministratorRepository;
import com.dichoyhecho.dichoyhecho.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AdministratorRepository AdministratorRepository;

    public AutenService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AdministratorRepository AdministratorRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.AdministratorRepository = AdministratorRepository;
    }

    public void register (RegisterRequest req) {
        if (userRepository.existsByemail(req.email)) {
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

    public LoginResponse login (LoginRequest req) {
        Usuario user = userRepository.findByemail(req.email)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect email or does not exist."));

        boolean ok = passwordEncoder.matches(req.password, user.getPassword());
        if (!ok) throw new IllegalArgumentException("Contraseña incorrecta");
        return new LoginResponse("Successful login: ",user.getId(), user.getFirstName(), user.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = userRepository.findByemail(email).orElse(null);

        if (user != null) {
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        }

        Administrator admin = AdministratorRepository.findByCorreo(email).orElse(null);

        if (admin != null) {
            return User.builder()
                    .username(admin.getEmail())
                    .password(admin.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }

}
