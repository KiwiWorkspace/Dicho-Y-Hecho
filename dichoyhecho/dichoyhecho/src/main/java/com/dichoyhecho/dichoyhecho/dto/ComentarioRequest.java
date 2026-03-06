package com.dichoyhecho.dichoyhecho.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ComentarioRequest {
    @NotBlank(message = "Debe ingresar contenido para su comentario")
    public String contenido;
    @NotNull(message = "El ID de usuario es obligatorio")
    public Long idUsuario;

    //recibir  imagen y video de post
    private MultipartFile imagen;
    private MultipartFile video;

        public String getContenido() { return contenido; }
        public void setContenido(String contenido) { this.contenido = contenido; }

        public Long getIdUsuario() { return idUsuario; }
        public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }
}

