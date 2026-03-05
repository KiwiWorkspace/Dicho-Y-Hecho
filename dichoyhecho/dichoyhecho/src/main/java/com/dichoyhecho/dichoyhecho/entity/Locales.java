package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import com.dichoyhecho.dichoyhecho.enums.EstadoLocales;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "locales")
public class Locales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locales")
    private Integer id_locales;

    @NotBlank(message = "Por favor ingrese el nombre de su negocio.")
    @Size(min = 1, max = 100, message = "El nombre del negocio tiene como máximo 100 caracteres.")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "Por favor ingrese la descripción de su negocio.")
    @Size(min = 50, max = 300, message = "La descripción debe tener mínimo 50 caracteres y máximo 300.")
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @NotBlank(message = "Por favor ingrese el número de teléfono de su negocio.")
    @Size(min = 1, max = 12, message = "El número de teléfono no puede exceder 12 caracteres.")
    @Column(name = "telefono", nullable = false, length = 12)
    private String telefono;

    @NotBlank(message = "Por favor ingrese el correo de su negocio.")
    @Email(message = "El correo ingresado no tiene un formato válido.")
    @Size(min = 1, max = 50, message = "El correo no puede exceder 50 caracteres.")
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "id_categoria")
    private String id_categoria;

    @Column(name = "direccion_asociada")
    private String direccion_asociada;

    // Al subir un local siempre arranca como PENDIENTE, el admin decide despues
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoLocales estado = EstadoLocales.PENDIENTE;

    @Column(name = "motivo_rechazo", length = 300)
    private String motivoRechazo;

    public Integer getId_locales() { return id_locales; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getId_categoria() { return id_categoria; }
    public String getDireccion_asociada() { return direccion_asociada; }
    public EstadoLocales getEstado() { return estado; }
    public String getMotivoRechazo() { return motivoRechazo; }


    public void setId_locales(Integer id_locales) { this.id_locales = id_locales; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setId_categoria(String id_categoria) { this.id_categoria = id_categoria; }
    public void setDireccion_asociada(String direccion_asociada) { this.direccion_asociada = direccion_asociada; }
    public void setEstado(EstadoLocales estado) { this.estado = estado; }
    public void setMotivoRechazo(String motivoRechazo) { this.motivoRechazo = motivoRechazo; }
}