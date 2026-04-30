package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.ProblemCategory;
import com.dichoyhecho.dichoyhecho.enums.ProblemStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "problem")
public class Problems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "You must enter the problem type")
    @NotBlank(message = "You must enter the problem type")
    @Size(min = 20, max = 130, message = "The problem type must have between 20 and 130 characters")
    @Column(name = "type")
    private String type;

    @NotNull(message = "You must enter the location of the problem")
    @NotBlank(message = "You must enter the location of the problem")
    @Size(min = 20, max = 120, message = " The problem address must have between 20 and 120 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "You must enter the problem category")
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProblemCategory category;

    @NotNull(message = "You must enter the problem status")
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProblemStatus status;

    @NotNull(message = "You must enter whether the user wants to receive notifications about the problem")
    @Column(name = "notification")
    private boolean notification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProblemCategory getCategory() {
        return category;
    }

    public void setCategory(ProblemCategory category) {
        this.category = category;
    }

    public ProblemStatus getStatus() {
        return status;
    }

    public void setStatus(ProblemStatus status) {
        this.status = status;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}
