package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "areas_verdes")
public class AreasVerdes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer id_area;

}
