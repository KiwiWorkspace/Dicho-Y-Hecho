package com.dichoyhecho.dichoyhecho.service;


import com.dichoyhecho.dichoyhecho.dto.LoginUserRequest;
import com.dichoyhecho.dichoyhecho.dto.LoginUserResponse;
import com.dichoyhecho.dichoyhecho.dto.RegisterUserRequest;
import com.dichoyhecho.dichoyhecho.repository.AdminRepository;
import com.dichoyhecho.dichoyhecho.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import com.dichoyhecho.dichoyhecho.entity.Admins;
import com.dichoyhecho.dichoyhecho.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
    }

    public void register(RegisterUserRequest req) {
        if (userRepository.existsByEmailUser(req.email)) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        String hash = passwordEncoder.encode(req.password);
        Users user = new Users(
                req.name,
                req.lastName,
                hash,
                req.handle,
                req.email,
                req.age,
                null);
        userRepository.save(user);
    }

    public LoginUserResponse login(LoginUserRequest req) {
        Users users = userRepository.findByEmail(req.email).orElse(null);

        if (users != null) {
            boolean ok = passwordEncoder.matches(req.password, users.getPassword());
            if (!ok) throw new IllegalArgumentException("Incorrect password");
            return new LoginUserResponse("Login successful: ", users.getIdUser(), users.getFirstName(), users.getEmailUser());
        }

        Admins admins = adminRepository.findByCorreo(req.email).orElse(null);
        if (admins != null) {
            boolean ok = passwordEncoder.matches(req.password, admins.getPassword());
            if (!ok) throw new IllegalArgumentException("Incorrect password");

            return new LoginUserResponse(
                    "Login successful",
                    admins.getId(),
                    admins.getFirstName(),
                    admins.getEmail()
            );
        }
        throw new IllegalArgumentException("Email is incorrect or does not exist.");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users users = userRepository.findByEmail(email).orElse(null);

        if (users != null) {
            return User.builder()
                    .username(users.getEmailUser())
                    .password(users.getPassword())
                    .roles("USER")
                    .build();
        }

        Admins admins = adminRepository.findByCorreo(email).orElse(null);

        if (admins != null) {
            return User.builder()
                    .username(admins.getEmail())
                    .password(admins.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}