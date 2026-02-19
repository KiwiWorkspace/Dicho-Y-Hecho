package com.dichoyhecho.dichoyhecho.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "idAdmin",
    "nombre",
    "apellidos",
    "edad",
    "direccion",
    "contraseña"
})
public class Administrador {
}
