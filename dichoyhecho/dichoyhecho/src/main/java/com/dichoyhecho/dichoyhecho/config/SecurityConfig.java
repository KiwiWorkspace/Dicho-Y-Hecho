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
                        .requestMatchers("/admin/post").hasRole("ADMIN")
                        .requestMatchers("/usuario/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/dichoyhecho/comentarios/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {});

        return http.build();
    }
}
