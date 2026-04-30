package com.dichoyhecho.dichoyhecho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "green_area")
public class GreenArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areaId")
    private Integer id;

    @NotBlank(message = "You must enter the area name")
    @Size(min = 3, max = 60, message = "The area name must have between 3 and 60 characters")
    @Column(name = "area_name")
    private String areaName;

    @NotBlank(message = "You must enter the area type")
    @Size(min = 3, max = 30, message = "The area type must have between 3 and 30 characters")
    @Column(name = "area_type")
    private String areaType;

    @NotBlank(message = "You must enter the area location")
    @Size(min = 3, max = 50, message = "The area location must have between 3 and 50 characters")
    @Column(name = "area_location")
    private String areaLocation;

    @NotBlank(message = "You must enter the area status")
    @Size(min = 3, max = 30, message = "The area status must have between 3 and 30 characters")
    @Column(name = "area_status")
    private String areaStatus;

    public String getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(String areaStatus) {
        this.areaStatus = areaStatus;
    }

    public String getAreaLocation() {
        return areaLocation;
    }

    public void setAreaLocation(String areaLocation) {
        this.areaLocation = areaLocation;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}