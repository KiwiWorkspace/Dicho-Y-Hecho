package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Locales;
import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFoundException;
import com.dichoyhecho.dichoyhecho.repository.LocalesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalesServiceImpl implements LocalesService {

    private final LocalesRepository localesRepository;

    public LocalesServiceImpl(LocalesRepository localesRepository) {
        this.localesRepository = localesRepository;
    }

    @Override
    @Transactional
    public Locales crear(Locales locales) {
        locales.setId_locales(null);
        locales.setEstado(EstadoLocales.PENDIENTE);
        locales.setMotivoRechazo(null);
        return localesRepository.save(locales);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Locales> listar() {
        return localesRepository.findByEstado(EstadoLocales.APROBADO);
    }

    @Override
    @Transactional(readOnly = true)
    public Locales obtenerPorId(Integer id) {
        return localesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Local con ID no encontrado: " + id));
    }

    @Override
    @Transactional
    public Locales actualizar(Integer id, Locales locales) {
        Locales existente = obtenerPorId(id);
        locales.setId_locales(id);
        locales.setEstado(existente.getEstado());
        locales.setMotivoRechazo(existente.getMotivoRechazo());
        return localesRepository.save(locales);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        if (!localesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Local con ID no encontrado: " + id);
        }
        localesRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Locales> listarPendientes() {
        return localesRepository.findByEstado(EstadoLocales.PENDIENTE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Locales> listarTodos() {
        return localesRepository.findAll();
    }

    @Override
    @Transactional
    public Locales aprobar(Integer id) {
        Locales local = obtenerPorId(id);

        if (local.getEstado() != EstadoLocales.PENDIENTE) {
            throw new IllegalStateException(
                    "El local con ID " + id + " no está en estado PENDIENTE, está: " + local.getEstado()
            );
        }

        local.setEstado(EstadoLocales.APROBADO);
        local.setMotivoRechazo(null);
        return localesRepository.save(local);
    }

    @Override
    @Transactional
    public Locales rechazar(Integer id, String motivoRechazo) {
        Locales local = obtenerPorId(id);

        if (local.getEstado() != EstadoLocales.PENDIENTE) {
            throw new IllegalStateException(
                    "El local con ID " + id + " no está en estado PENDIENTE, está: " + local.getEstado()
            );
        }

        if (motivoRechazo == null || motivoRechazo.isBlank()) {
            throw new IllegalArgumentException("Debe proporcionar un motivo de rechazo.");
        }

        local.setEstado(EstadoLocales.RECHAZADO);
        local.setMotivoRechazo(motivoRechazo);
        return localesRepository.save(local);
    }
}