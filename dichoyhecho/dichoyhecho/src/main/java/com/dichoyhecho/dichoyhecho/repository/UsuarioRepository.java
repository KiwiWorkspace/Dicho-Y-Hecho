package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailUsuario(String emailUsuario);
    boolean existsByEmailUsuario(String emailUsuario);

}
