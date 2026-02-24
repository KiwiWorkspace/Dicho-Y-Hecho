package com.dichoyhecho.dichoyhecho.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@JsonPropertyOrder({
        "idUsuario",
        "nombreUsuario",
        "apellidoUsuario",
        "edadUsuario"
})
@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @Column(name = "handle_usuario")
    private String handleUsuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "edad_usuario")
    private Integer edadUsuario;

}
