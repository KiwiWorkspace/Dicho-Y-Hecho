package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "areas_verdes")
public class AreasVerdes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer idArea;


    @NotBlank(message = "Debe ingresar el nombre del area")
    @Size(min = 20, max = 60, message = "El nombre del area debe de tener entre 20 y 60 caracteres")
    @Column(name = "nombre_area")
    private String nombreArea;

    @Size(min = 20, max = 30, message = "El tipo de area debe tener entre 20 y 30 caracteres")
    @NotBlank(message = "debe ingresar el nombre del area")
    @Column(name = "tipo_area")
    private String tipoArea;

    @NotBlank(message = "debe ingresar la ubicacion  del area")
    @Size(min = 20, max = 50, message = "la ubicacion del area debe tener entre 20 y 50 caracteres")
    @Column(name = "ubicaicon_area")
    private String ubicacionArea;

    @NotBlank(message = "Debe ingresar el estado del area")
    @Size(min = 20, max = 30, message = "El estado del area debe tener entr 20 y 30 caracteres")
    @Column(name = "estado_area")
    private String estadoArea;


    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public @NotBlank(message = "Debe ingresar el nombre del area") @Size(min = 20, max = 60, message = "El nombre del area debe de tener entre 20 y 60 caracteres") String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(@NotBlank(message = "Debe ingresar el nombre del area") @Size(min = 20, max = 60, message = "El nombre del area debe de tener entre 20 y 60 caracteres") String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public @Size(min = 20, max = 30, message = "El tipo de area debe tener entre 20 y 30 caracteres") @NotBlank(message = "debe ingresar el nombre del area") String getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(@Size(min = 20, max = 30, message = "El tipo de area debe tener entre 20 y 30 caracteres") @NotBlank(message = "debe ingresar el nombre del area") String tipoArea) {
        this.tipoArea = tipoArea;
    }

    public @NotBlank(message = "debe ingresar la ubicacion  del area") @Size(min = 20, max = 50, message = "la ubicacion del area debe tener entre 20 y 50 caracteres") String getUbicacionArea() {
        return ubicacionArea;
    }

    public void setUbicacionArea(@NotBlank(message = "debe ingresar la ubicacion  del area") @Size(min = 20, max = 50, message = "la ubicacion del area debe tener entre 20 y 50 caracteres") String ubicacionArea) {
        this.ubicacionArea = ubicacionArea;
    }

    public @NotBlank(message = "Debe ingresar el estado del area") @Size(min = 20, max = 30, message = "El estado del area debe tener entr 20 y 30 caracteres") String getEstadoArea() {
        return estadoArea;
    }

    public void setEstadoArea(@NotBlank(message = "Debe ingresar el estado del area") @Size(min = 20, max = 30, message = "El estado del area debe tener entr 20 y 30 caracteres") String estadoArea) {
        this.estadoArea = estadoArea;
    }



}
