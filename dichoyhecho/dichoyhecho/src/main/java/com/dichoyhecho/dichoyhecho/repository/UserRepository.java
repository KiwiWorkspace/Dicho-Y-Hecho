package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmailUser(String email);
    boolean existsByEmailUser(String email);
    Optional<Users> findByUserHandle(String firstName);
}
