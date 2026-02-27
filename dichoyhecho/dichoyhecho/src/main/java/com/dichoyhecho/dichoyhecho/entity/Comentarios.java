package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "idUsuario",
        "nombreUsuario",
        "apellidoUsuario",
        "handleUsuario",
        "contrasena",
        "edadUsuario",
        "rolUsuario"
})
@Entity
@Table(name = "comentario")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
}
