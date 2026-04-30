package com.dichoyhecho.dichoyhecho.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "age",
        "email",
        "address",
        "identifier",
        "password"
})
@Entity
@Table(name = "administrator")
public class Admins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "You must enter an administrator first name")
    @Size(min = 4, max = 60, message = "The administrator first name must have between 4 and 60 characters")
    @Column(name = "name")
    private String firstName;

    @NotBlank(message = "You must enter an administrator last name")
    @Size(min = 2, max = 60, message = "The administrator last name must have between 2 and 60 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "The age cannot be empty.")
    @Min(value = 1, message = "The age must be greater than or equal to 1.")
    @Max(value = 120, message = "The age must be less than or equal to 120.")
    @Column(name = "age")
    private Integer age;

    @NotBlank(message = "You must enter the residential address of the administrator")
    @Size(min = 20, max = 120, message = "The residential address of the administrator must have between 20 and 120 characters")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "You must enter an administrator identifier")
    @Size(min = 5, max = 24, message = "The administrator identifier must have between 5 and 24 characters")
    @Column(name = "identifier")
    private String identifier;

    @NotBlank(message = "You must register an email address to be able to register")
    @Size(min = 12, max = 72, message = "The email must have a minimum of 12 characters and maximum of 72.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "You must enter the administrator password")
    @Size(min = 8, max = 75, message = "The password must have a minimum of 8 and maximum of 13 characters")
    @Column(name = "password")
    private String password;

    public Admins() {
    }

    public Admins(Integer id, String firstName, String lastName, Integer age, String address, String identifier, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.identifier = identifier;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
