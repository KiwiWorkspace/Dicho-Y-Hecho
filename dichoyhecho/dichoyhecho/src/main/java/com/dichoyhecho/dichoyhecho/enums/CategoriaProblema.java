package com.dichoyhecho.dichoyhecho.enums;

public enum CategoriaProblema {
    nivel_Bajo("nivel bajo"),
    nivelModerado("nivel moderado"),
    nivelAlto("nivel alto"),
    nivelCritico("nivel critico");

    //Variable para guardar el texto en el enum)
    private String descripcion;

    //constructor para guardar el valor dentro de la variable interna
    CategoriaProblema(String descripcion) {
        this.descripcion = descripcion;
    }

    //obtenemos el valor de la variable interna
    public String getDescripcion() {
        return descripcion;
    }
}
