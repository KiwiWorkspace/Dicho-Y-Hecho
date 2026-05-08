package com.dichoyhecho.dichoyhecho.config;

import com.dichoyhecho.dichoyhecho.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // object to encrypt the password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // object for the application user
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {

            // Admin predetermined
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                        .password(passwordEncoder().encode("1234"))
                        .roles("ADMIN")
                        .build();
            }

            // Users BD
            return userRepository.findByUserHandle(username)
                    .map(user -> User.builder()
                            .username(user.getUserHandle())
                            .password(user.getPassword())
                            .roles("USER")
                            .build()
                    )
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        };
    }

    // object for configuring Security routes
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/register/**", "/css/**").permitAll().anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll());

        return http.build();
    }
}