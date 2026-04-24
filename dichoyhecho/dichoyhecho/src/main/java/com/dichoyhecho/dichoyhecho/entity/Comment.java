package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "commentId",
        "contenido",
        "imagen",
        "video",
        "fecha_comentario",

})
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "You must enter content for your comment ")
    @Column(name = "contenido")
    private String content;

    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @Lob
    @Column(name= "video", columnDefinition = "LONGBLOB")
    private byte[] video;

    @NotNull
    @ManyToOne
    @JoinColumn (name= "userId", nullable = false)
    private Usuario user;

    @NotNull
    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    //se va a utilizar para que se coloque automaticamente la fecha
    @PrePersist
    protected void onCreate() {
        this.commentDate = LocalDateTime.now();
    }

    public long getId() {
        return commentId;
    }

    public void setId(long commentId) {
        this.id = commentId;
    }

    public String getContent() {
        return contenido;
    }

    public void setContent(String contenido) {
        this.content = contenido;
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

    public Usuario getId() {
        return userId;
    }

    public void setId(Usuario userId) {
        this.user = userId;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }
}
