package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Problemas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemasService {

    List<Problemas> listar();
    Problemas crear(Problemas problemas);
    Problemas actualizar(Integer id, Problemas problemas);
    void eliminar(Integer id);

}
