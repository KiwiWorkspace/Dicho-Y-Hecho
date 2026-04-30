package com.dichoyhecho.dichoyhecho.service;

import com.dichoyhecho.dichoyhecho.entity.Store;

import java.util.List;

public interface StoreService {

    Store create(Store locales);
    List<Store> list();
    Store GetById(Integer id);
    Store update(Integer id, Store locales);
    void delete(Integer id);
    List<Store> listPending();
    List<Store> listAll();
    Store approve(Integer id);
    Store reject(Integer id, String motivoRechazo);
}