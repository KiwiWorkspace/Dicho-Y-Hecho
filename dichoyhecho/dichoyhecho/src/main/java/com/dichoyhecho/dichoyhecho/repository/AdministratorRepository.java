package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Optional<Administrator> findByCorreo(String email);
    boolean existsByCorreo(String email);
}
