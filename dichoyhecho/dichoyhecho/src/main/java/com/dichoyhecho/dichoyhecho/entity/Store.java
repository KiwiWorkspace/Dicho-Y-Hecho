package com.dichoyhecho.dichoyhecho.entity;

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
    @Column(name = "status", nullable = false, length = 20)
    private StoreStatus status = StoreStatus.PENDING;

    @Column(name = "rejection_reason", length = 300)
    private String rejectionReason;

    public Store() {
    }

    public Store(Integer id, String name, String description, String telephone, String email, String categoryId, String associatedAddress, StoreStatus status, String rejectionReason) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.telephone = telephone;
        this.email = email;
        this.categoryId = categoryId;
        this.associatedAddress = associatedAddress;
        this.status = status;
        this.rejectionReason = rejectionReason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAssociatedAddress() {
        return associatedAddress;
    }

    public void setAssociatedAddress(String associatedAddress) {
        this.associatedAddress = associatedAddress;
    }

    public StoreStatus getStatus() {
        return status;
    }

    public void setStatus(StoreStatus status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}