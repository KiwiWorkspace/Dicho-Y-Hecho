package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.StoreDecisionDTO;
import com.dichoyhecho.dichoyhecho.entity.Store;
import com.dichoyhecho.dichoyhecho.enums.StoreStatus;
import com.dichoyhecho.dichoyhecho.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/locales")
public class AdminStoreController {

    private final StoreService StoreService;

    public AdminStoreController(StoreService StoreService) {
        this.StoreService = StoreService;
    }

    @GetMapping
    public List<Store> listAll() {
        return StoreService.listAll();
    }


    @GetMapping("/pendientes")
    public List<Store> listPending() {
        return StoreService.listPending();
    }

    @PatchMapping("/{id}/decision")
    public ResponseEntity<Store> decidir(
            @PathVariable Integer id,
            @Valid @RequestBody StoreDecisionDTO dto) {

        if (dto.getDecision() == StoreStatus.PENDING) {
            return ResponseEntity.badRequest().build();
        }

        Store result;
        if (dto.getDecision() == StoreStatus.APPROVED) {
            result = StoreService.approve(id);
        } else {
            result = StoreService.reject(id, dto.getRejectionReason());
        }

        return ResponseEntity.ok(result);
    }
}