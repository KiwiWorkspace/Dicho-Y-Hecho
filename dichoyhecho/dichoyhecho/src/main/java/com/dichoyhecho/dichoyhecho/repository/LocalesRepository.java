package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Locales;
import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalesRepository extends JpaRepository<Locales, Integer> {

    List<Locales> findByEstado(EstadoLocales estado);
}