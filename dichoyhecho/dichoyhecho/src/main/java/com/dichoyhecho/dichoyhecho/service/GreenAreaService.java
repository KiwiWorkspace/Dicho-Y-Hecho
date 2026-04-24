package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.GreenArea;
import com.dichoyhecho.dichoyhecho.entity.Usuario;

import java.util.List;

public interface GreenAreaService {
List<GreenArea> list();
GreenArea findById(Integer id);
GreenArea create(GreenArea areasVerdes);
GreenArea update(Integer id, GreenArea areasVerdes);
void delete(Integer id);
}
