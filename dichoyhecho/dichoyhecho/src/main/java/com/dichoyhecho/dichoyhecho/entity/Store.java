package com.dichoyhecho.dichoyhecho.entity;

import com.dichoyhecho.dichoyhecho.enums.StoreStatus;
import com.dichoyhecho.dichoyhecho.enums.StoreStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Please enter your business name.")
    @Size(min = 1, max = 100, message = "The business name cannot exceed 100 characters.")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Please enter your business description.")
    @Size(min = 50, max = 300, message = "The description must have between 50 and 300 characters.")
    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @NotBlank(message = "Please enter your business phone number.")
    @Size(min = 1, max = 12, message = "The phone number cannot exceed 12 characters.")
    @Column(name = "telephone", nullable = false, length = 12)
    private String telephone;

    @NotBlank(message = "Please enter your business email.")
    @Email(message = "The entered email does not have a valid format.")
    @Size(min = 1, max = 50, message = "The email cannot exceed 50 characters.")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "categoryId")
    private String categoryId;

    @Column(name = "associatedAddress")
    private String associatedAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private StoreStatus estado = StoreStatus.PENDING;

    @Column(name = "rejection_reason", length = 300)
    private String rejectionReason;

    public Integer getId() { return id; }
    public String getFirstName() { return name; }
    public String getDescripcion() { return description; }
    public String getTelefono() { return telephone; }
    public String getEmail() { return email; }
    public String getCategoryId() { return categoryId; }
    public String getAssociatedAddress() { return associatedAddress; }
    public StoreStatus getStatus() { return estado; }
    public String getRejectionReason() { return rejectionReason; }


    public void setId(Integer id) { this.id = id; }
    public void setFirstName(String name) { this.name = name; }
    public void setDescripcion(String description) { this.description = description; }
    public void setTelefono(String telephone) { this.telephone = telephone; }
    public void setEmail(String email) { this.email = email; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public void setAssociatedAddress(String associatedAddress) { this.associatedAddress = associatedAddress; }
    public void setStatus(StoreStatus estado) { this.estado = estado; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
}