package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Store;
import com.dichoyhecho.dichoyhecho.enums.StoreStatus;
import com.dichoyhecho.dichoyhecho.exception.ResourceNotFound;
import com.dichoyhecho.dichoyhecho.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository StoreRepository;

    public StoreServiceImpl(StoreRepository StoreRepository) {
        this.StoreRepository = StoreRepository;
    }

    @Override
    @Transactional
    public Store create(Store locales) {
        locales.setId(null);
        locales.setStatus(StoreStatus.PENDING);
        locales.setRejectionReason(null);
        return StoreRepository.save(locales);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> list() {
        return StoreRepository.findByEstado(StoreStatus.APPROVED);
    }

    @Override
    @Transactional(readOnly = true)
    public Store GetById(Integer id) {
        return StoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Local with ID not found: " + id));
    }

    @Override
    @Transactional
    public Store update(Integer id, Store locales) {
        Store existente = GetById(id);
        locales.setId(id);
        locales.setStatus(existente.getStatus());
        locales.setRejectionReason(existente.getRejectionReason());
        return StoreRepository.save(locales);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!StoreRepository.existsById(id)) {
            throw new ResourceNotFound("Local with ID not found: " + id);
        }
        StoreRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> listPending() {
        return StoreRepository.findByEstado(StoreStatus.PENDING);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> listAll() {
        return StoreRepository.findAll();
    }

    @Override
    @Transactional
    public Store approve(Integer id) {
        Store local = GetById(id);

        if (local.getStatus() != StoreStatus.PENDING) {
            throw new IllegalStateException(
                    "El local con ID " + id + " no está en estado PENDIENTE, está: " + local.getStatus()
            );
        }

        local.setStatus(StoreStatus.APPROVED);
        local.setRejectionReason(null);
        return StoreRepository.save(local);
    }

    @Override
    @Transactional
    public Store reject(Integer id, String motivoRechazo) {
        Store local = GetById(id);

        if (local.getStatus() != StoreStatus.PENDING) {
            throw new IllegalStateException(
                    "El local con ID " + id + " no está en estado PENDIENTE, está: " + local.getStatus()
            );
        }

        if (motivoRechazo == null || motivoRechazo.isBlank()) {
            throw new IllegalArgumentException("You must provide a reason for rejection.");
        }

        local.setStatus(StoreStatus.REJECTED);
        local.setRejectionReason(motivoRechazo);
        return StoreRepository.save(local);
    }
}