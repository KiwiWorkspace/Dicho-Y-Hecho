package com.dichoyhecho.dichoyhecho.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private long commentId;

    @NotBlank(message = "You must enter content for your comment ")
    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "image_url", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @Lob
    @Column(name= "video_url", columnDefinition = "LONGBLOB")
    private byte[] video;

    @NotNull
    @ManyToOne
    @JoinColumn (name= "id_user", nullable = false)
    private Users idUser;

    @NotNull
    @Column(name = "id_zone")
    private Integer idZone;

    @NotNull
    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    //se va a utilizar para que se coloque automaticamente la fecha
    @PrePersist
    protected void onCreate() {
        this.commentDate = LocalDateTime.now();
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public String generateBase64Image() {
        if (this.imagen == null) {
            return null;
        }
        return java.util.Base64.getEncoder().encodeToString(this.imagen);
    }

    public String generateBase64Video() {
        if (this.video == null) {
            return null;
        }
        return java.util.Base64.getEncoder().encodeToString(this.video);
    }
}
