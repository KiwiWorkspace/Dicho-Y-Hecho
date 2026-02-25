package com.dichoyhecho.dichoyhecho.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@JsonPropertyOrder({
        "idUsuario",
        "nombreUsuario",
        "apellidoUsuario",
        "edadUsuario"
})
@Entity
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getHandleUsuario() {
        return handleUsuario;
    }

    public void setHandleUsuario(String handleUsuario) {
        this.handleUsuario = handleUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }
}
