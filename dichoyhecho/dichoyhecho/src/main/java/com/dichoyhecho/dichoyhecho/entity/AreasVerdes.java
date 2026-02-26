package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "areas_verdes")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AreasVerdes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer id_area;

    @Column(name = "nombre_area")
    private String nombre_area;

    @Column(name = "tipo_area")
    private String tipo_area;

    @Column(name = "ubicaicon_area")
    private String ubicacion_area;

    @Column(name = "estado_area")
    private String estado_area;




}
