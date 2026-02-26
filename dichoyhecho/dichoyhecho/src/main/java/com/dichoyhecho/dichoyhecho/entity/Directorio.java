package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.w3c.dom.Text;

@Entity
@Table(name = "directorio")
public class Directorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_directorio")
    private Integer id_directorio;

    @NotBlank(message = "Porfavor ingrese el nombre de su negocio.")
    @Size(min=1, max=100, message = "El nombre del negocio tiene como maximo 100 caracteres.")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Porfavor ingrese la descripcion de su negocio.")
    @Size(min=50, max=300, message = "La descripcion del negocio debe de tener como minimo 50 caracteres y maximo 300..")
    @Column(name = "text")
    private Text descripcion;

    @NotBlank(message = "Porfavor ingrese el numero de telefono de su negocio.")
    @Size(min=1, max=12, message = "El numero de telefono no puede excederse de 12 caracteres.")
    @Column(name = "telefono")
    private String telefono;

    @NotBlank(message = "Porfavor ingrese el correo de negocios de su negocio.")
    @Size(min=1, max=12, message = "El numero de telefono no puede excederse de 12 caracteres.")
    @Column(name = "correo")
    private String correo;

    @Column(name = "id_categoria")
    private Text id_categoria;

    @Column(name = "direccion_asociada")
    private String direccion_asociada;

}
