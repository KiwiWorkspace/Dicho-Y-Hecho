package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "areas_verdes")
public class AreasVerdes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer idArea;

    @NotBlank(message = "Debe ingresar el nombre del area")
    @Size(min = 3, max = 60, message = "El nombre del area debe tener entre 3 y 60 caracteres")
    @Column(name = "nombre_area")
    private String nombreArea;

    @NotBlank(message = "Debe ingresar el tipo del area")
    @Size(min = 3, max = 30, message = "El tipo de area debe tener entre 3 y 30 caracteres")
    @Column(name = "tipo_area")
    private String tipoArea;

    @NotBlank(message = "Debe ingresar la ubicacion del area")
    @Size(min = 3, max = 50, message = "La ubicacion del area debe tener entre 3 y 50 caracteres")
    @Column(name = "ubicacion_area")
    private String ubicacionArea;

    @NotBlank(message = "Debe ingresar el estado del area")
    @Size(min = 3, max = 30, message = "El estado del area debe tener entre 3 y 30 caracteres")
    @Column(name = "estado_area")
    private String estadoArea;

    public Integer getIdArea() { return idArea; }
    public void setIdArea(Integer idArea) { this.idArea = idArea; }

    public String getNombreArea() { return nombreArea; }
    public void setNombreArea(String nombreArea) { this.nombreArea = nombreArea; }

    public String getTipoArea() { return tipoArea; }
    public void setTipoArea(String tipoArea) { this.tipoArea = tipoArea; }

    public String getUbicacionArea() { return ubicacionArea; }
    public void setUbicacionArea(String ubicacionArea) { this.ubicacionArea = ubicacionArea; }

    public String getEstadoArea() { return estadoArea; }
    public void setEstadoArea(String estadoArea) { this.estadoArea = estadoArea; }
}