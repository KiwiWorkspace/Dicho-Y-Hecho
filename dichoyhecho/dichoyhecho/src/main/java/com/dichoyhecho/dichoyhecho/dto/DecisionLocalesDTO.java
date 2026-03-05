package com.dichoyhecho.dichoyhecho.dto;

import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import jakarta.validation.constraints.NotNull;

public class DecisionLocalesDTO {

    // El admin solo puede enviar APROBADO o RECHAZADO, nunca PENDIENTE
    @NotNull(message = "Debe indicar una decisión: APROBADO o RECHAZADO.")
    private EstadoLocales decision;

    // Obligatorio solo si la decisión es RECHAZADO, se valida en el servicio
    private String motivoRechazo;

    public EstadoLocales getDecision() { return decision; }
    public String getMotivoRechazo() { return motivoRechazo; }

    public void setDecision(EstadoLocales decision) { this.decision = decision; }
    public void setMotivoRechazo(String motivoRechazo) { this.motivoRechazo = motivoRechazo; }
}