package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "idComentario",
        "contenido",
        "imagen",
        "video",
        "fecha_comentario",

})
@Entity
@Table(name = "comentario")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private long idComentario;

    @NotBlank(message = "Debe ingresar contenido para su comentario ")
    @Column(name = "contenido")
    private String contenido;

    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @Lob
    @Column(name= "video", columnDefinition = "LONGBLOB")
    private byte[] video;

    @NotNull
    @ManyToOne
    @JoinColumn (name= "id_usuario", nullable = false)
    private Usuario idUsuario;

    @NotNull
    @Column(name = "fecha_comentario")
    private LocalDateTime fechaComentario;

    //se va a utilizar para que se coloque automaticamente la fecha
    @PrePersist
    protected void onCreate() {
        this.fechaComentario = LocalDateTime.now();
    }

}
