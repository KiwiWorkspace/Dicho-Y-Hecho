package com.dichoyhecho.dichoyhecho.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "idAdministrador",
        "nombre",
        "apellido",
        "edad",
        "direccion",
        "identificador",
        "contrasena"
})
@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Integer idAdministrador;

    @NotBlank(message = "Debe ingresar un nombre del administrador")
    @Size(min = 4, max = 60, message = "El nombre del administrador debe tener 4 y 60 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar un apellido del administrador")
    @Size(min = 2, max = 60, message = "El apellido del administrador debe tener 2 y 60 caracteres")
    @Column(name = "apellido")
    private String apellido;

    @NotNull(message = "La edad no puede ir vacia.")
    @Min(value = 1, message = "La edad debe ser mayor o igual a 1.")
    @Max(value = 120, message = "La edad debe ser menor o igual a 120.")
    @Column(name = "edad")
    private Integer edad;

    @NotBlank(message = "Debe ingresar la direccion de residencia del administrador")
    @Size(min = 20, max = 120, message = " La direccion de residencia del administrador debe tener 20 y 120 caracteres")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank(message = "Debe ingresar un nombre del usuario")
    @Size(min = 5, max = 24, message = "El identificador del administrador debe tener 5 y 24 caracteres")
    @Column(name = "identificador")
    private String identificador;

    @NotBlank(message = "Debe ingresar un nombre del usuario")
    @Size(min = 8, max = 13, message = "La contraseña debe terner un min de 8 y max 13 caracteres")
    @Column(name = "contrasena")
    private String contrasena;

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
