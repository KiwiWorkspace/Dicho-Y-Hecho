package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "idComentario",
        "contenido",
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
    @Column(name = "id_comentario")
    private Integer idComentario;

    @NotBlank(message = "Debe ingresar contenido para su comentario ")
    @Column(name = "contenido")
    private String contenido;

    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen;
}
