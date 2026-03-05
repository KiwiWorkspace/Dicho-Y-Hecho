package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;

import java.util.List;

public interface LocalesService {

    // ── Usuario ──────────────────────────────────────────────────────────────

    Locales crear(Locales locales);

    List<Locales> listar();

    Locales obtenerPorId(Integer id);

    Locales actualizar(Integer id, Locales locales);

    void eliminar(Integer id);

    // ── Admin ─────────────────────────────────────────────────────────────────


    List<Locales> listarPendientes();

    List<Locales> listarTodos();

    Locales aprobar(Integer id);

    Locales rechazar(Integer id, String motivoRechazo);
}