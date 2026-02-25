package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "directorio")
public class Directorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_directorio")
    private Integer id_directorio;
    
}
