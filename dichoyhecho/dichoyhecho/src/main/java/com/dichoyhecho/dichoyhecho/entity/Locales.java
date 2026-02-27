package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "locales")
public class Locales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locales")
    private Integer id_locales;

    @NotBlank(message = "Porfavor ingrese el nombre de su negocio.")
    @Size(min=1, max=100, message = "El nombre del negocio tiene como maximo 100 caracteres.")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Porfavor ingrese la descripcion de su negocio.")
    @Size(min=50, max=300, message = "La descripcion del negocio debe de tener como minimo 50 caracteres y maximo 300..")
    @Column(name = "text")
    private String descripcion;

    @NotBlank(message = "Porfavor ingrese el numero de telefono de su negocio.")
    @Size(min=1, max=12, message = "El numero de telefono no puede excederse de 12 caracteres.")
    @Column(name = "telefono")
    private String telefono;

    @NotBlank(message = "Porfavor ingrese el correo de negocios de su negocio.")
    @Size(min=1, max=12, message = "El numero de telefono no puede excederse de 12 caracteres.")
    @Column(name = "correo")
    private String correo;

    @Column(name = "id_categoria")
    private String id_categoria;

    @Column(name = "direccion_asociada")
    private String direccion_asociada;

    public void setId_locales(Integer id_locales) {
        this.id_locales = id_locales;
    }


}
