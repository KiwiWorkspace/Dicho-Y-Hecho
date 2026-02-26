package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.AreasVerdes;
import com.dichoyhecho.dichoyhecho.entity.Usuario;

import java.util.List;

public interface AreasVerdesService {
List<AreasVerdes> listar();
AreasVerdes buscarPorId(Integer id);
AreasVerdes crear(AreasVerdes areasVerdes);
AreasVerdes actualizar(Integer id, AreasVerdes areasVerdes);
void eliminar(Integer id);
}
