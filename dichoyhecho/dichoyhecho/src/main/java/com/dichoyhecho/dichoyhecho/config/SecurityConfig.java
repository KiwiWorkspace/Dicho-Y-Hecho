package com.dichoyhecho.dichoyhecho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dichoyhecho/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/dichoyhecho/admin/post").permitAll()
                        .requestMatchers("/dichoyhecho/admin/**").hasRole("ADMIN")
                        .requestMatchers("/dichoyhecho/usuario/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/dichoyhecho/comentarios/**").permitAll()

                        // Todo lo demás requiere autenticación
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {});

        return http.build();
    }
}