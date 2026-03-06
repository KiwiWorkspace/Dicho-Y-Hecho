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

    public long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(long idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}
