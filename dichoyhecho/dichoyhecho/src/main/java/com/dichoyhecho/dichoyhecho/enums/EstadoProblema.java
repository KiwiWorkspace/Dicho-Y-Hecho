package com.dichoyhecho.dichoyhecho.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum EstadoProblema {
    reportado("reportado"),
    enInspeccionTecnica("En inspeccion tecnica"),
    pendienteDeAprobacion("Pediente de aprobación"),
    enRevision("En revisión"),
    programado("Programado"),
    enProceso("En proceso"),
    resuelto("Resuelto"),
    rechazado("rechazado");

    //se crea una variable para guardar una constante (el texto que se guardara el enum)
    private String estado;

    //constructor para guardar el valor dentro de la variable (estado)
    EstadoProblema(String estado) {
        this.estado = estado;
    }

    //obtenemos el valor de la variable interna
    @JsonValue
    public String getEstado() {
        return estado;
    }

    @JsonCreator
    public static EstadoProblema descripcionEstado(String estado){
        return Arrays.stream(values()).filter(c -> c.estado.equalsIgnoreCase(estado))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("La estado es invalido: " + estado));

    }
}
