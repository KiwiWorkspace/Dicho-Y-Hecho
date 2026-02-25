package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.CategoriaProblema;
import com.dichoyhecho.dichoyhecho.enums.EstadoProblema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "problemas")
public class Problemas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema")
    private Integer id_problema;

    @NotBlank(message = "Debe ingresar el tipo del problema")
    @Size(min = 20, max = 130, message = "El tipo de problema debe tener 20 y 130 caracteres")
    @Column(name = "tipo")
    private String tipo;

    @NotBlank(message = "Debe ingresar la direccion de donde se ubica el problema")
    @Size(min = 20, max = 120, message = " La direccion del problema debe tener 20 y 120 caracteres")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "Debe ingresar la categoria del problema")
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaProblema categoria;

    @NotNull(message = "Debe ingresar la estado en el que se encuentre el problema")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoProblema estado;

    @NotNull(message = "Debe ingresar el estado de la notificación")
    @Column(name = "notificacion")
    private boolean notificacion;

    public Integer getId_problema() {
        return id_problema;
    }

    public void setId_problema(Integer id_problema) {
        this.id_problema = id_problema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CategoriaProblema getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProblema categoria) {
        this.categoria = categoria;
    }

    public EstadoProblema getEstado() {
        return estado;
    }

    public void setEstado(EstadoProblema estado) {
        this.estado = estado;
    }

    public boolean isNotificacion() {
        return notificacion;
    }

    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }
}
