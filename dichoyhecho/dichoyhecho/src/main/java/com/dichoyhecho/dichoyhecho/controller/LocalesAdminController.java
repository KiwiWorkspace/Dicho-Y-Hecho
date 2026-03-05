package com.dichoyhecho.dichoyhecho.controller;

import com.dichoyhecho.dichoyhecho.dto.DecisionLocalesDTO;
import com.dichoyhecho.dichoyhecho.entity.Locales;
import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import com.dichoyhecho.dichoyhecho.service.LocalesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichoyhecho/admin/locales")
public class LocalesAdminController {

    private final LocalesService localesService;

    public LocalesAdminController(LocalesService localesService) {
        this.localesService = localesService;
    }

    @GetMapping
    public List<Locales> listarTodos() {
        return localesService.listarTodos();
    }


    @GetMapping("/pendientes")
    public List<Locales> listarPendientes() {
        return localesService.listarPendientes();
    }

    @PatchMapping("/{id}/decision")
    public ResponseEntity<Locales> decidir(
            @PathVariable Integer id,
            @Valid @RequestBody DecisionLocalesDTO dto) {

        if (dto.getDecision() == EstadoLocales.PENDIENTE) {
            return ResponseEntity.badRequest().build();
        }

        Locales resultado;
        if (dto.getDecision() == EstadoLocales.APROBADO) {
            resultado = localesService.aprobar(id);
        } else {
            resultado = localesService.rechazar(id, dto.getMotivoRechazo());
        }

        return ResponseEntity.ok(resultado);
    }
}