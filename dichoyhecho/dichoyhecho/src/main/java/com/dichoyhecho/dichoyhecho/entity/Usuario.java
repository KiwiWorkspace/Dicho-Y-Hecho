package com.dichoyhecho.dichoyhecho.entity;


import com.dichoyhecho.dichoyhecho.enums.EstadoProblema;
import com.dichoyhecho.dichoyhecho.enums.UsuarioRoles;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.ToString;

@JsonPropertyOrder({
        "idUsuario",
        "nombreUsuario",
        "apellidoUsuario",
        "handleUsuario",
        "contrasena",
        "emailUsuario",
        "edadUsuario",
        "rolUsuario"
})
@ToString
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "emailUsuario")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "Debe ingresar un nombre ")
    @Size(min = 2, max = 60, message = "Su nombre  debe tener 2 y 60 caracteres")
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotBlank(message = "Debe ingresar un apellido ")
    @Size(min = 2, max = 60, message = "Su apellido  debe tener 2 y 60 caracteres")
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @NotBlank(message = "Debe ingresar un apodo para su  usuario")
    @Size(min = 3, max = 60, message = "Su apodo debe tener 3 y 60 caracteres")
    @Column(name = "handle_usuario")
    private String handleUsuario;

    @NotBlank(message = "Debe ingresar una contrasena")
    @Size(min = 8, max = 12, message = "La contraseña debe terner de 8 a 12 caracteres")
    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @NotNull(message = "Debe ingresar una edad ")
    @Min(value = 3, message = "La edad debe ser mayor a 3")
    @Max(value = 135, message = "La edad debe ser menor a 135")
    @Column(name = "edad_usuario")
    private Integer edadUsuario;

    @NotNull(message = "Debe ingresar un rol a su usuario")
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_usuario")
    private UsuarioRoles rolUsuario;

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

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public UsuarioRoles getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(UsuarioRoles rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    //constructores

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String apellidoUsuario, String contrasena, String handleUsuario, String emailUsuario, Integer edadUsuario, UsuarioRoles rolUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.contrasena = contrasena;
        this.handleUsuario = handleUsuario;
        this.emailUsuario = emailUsuario;
        this.edadUsuario = edadUsuario;
        this.rolUsuario = rolUsuario;
    }
}
