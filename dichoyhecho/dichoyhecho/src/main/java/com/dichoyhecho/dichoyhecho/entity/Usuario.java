package com.dichoyhecho.dichoyhecho.entity;


import com.dichoyhecho.dichoyhecho.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.ToString;

@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "userHandle",
        "password",
        "email",
        "age",
        "userRole"
})
@ToString
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    @NotBlank(message = "You must enter a name ")
    @Size(min = 2, max = 60, message = "Your name must have between 2 and 60 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "You must enter a last name ")
    @Size(min = 2, max = 60, message = "Your last name must have between 2 and 60 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "You must enter a username")
    @Size(min = 3, max = 60, message = "Your username must have between 3 and 60 characters")
    @Column(name = "user_handle")
    private String userHandle;

    @NotBlank(message = "You must enter a password")
    @Size(min = 8, max =75, message = "The password must have between 8 and 12 characters")
    @Column(name = "password")
    private String password;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull(message = "You must enter an age ")
    @Min(value = 3, message = "The age must be greater than 3")
    @Max(value = 135, message = "The age must be less than 135")
    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = true)
    private UserRole userRole;

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

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    //constructors

    public User(@NotBlank String name, @Email @NotBlank String email, @NotBlank String password) {
    }

    public User(String firstName, String lastName, String password, String userHandle, String email, Integer age, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userHandle = userHandle;
        this.email = email;
        this.age = age;
        this.userRole = userRole;
    }

    public User(Integer id, String userHandle, String email) {
        this.id = id;
        this.userHandle = userHandle;
        this.email = email;
    }

    public User() {
    }
}
