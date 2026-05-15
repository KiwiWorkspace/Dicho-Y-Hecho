package com.dichoyhecho.dichoyhecho.entity;


import com.dichoyhecho.dichoyhecho.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.ToString;

@JsonPropertyOrder({
        "id_user",
        "firstName",
        "lastName",
        "userHandle",
        "password",
        "emailUser",
        "ageUser",
        "userRole"
})
@ToString
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "emailUser")
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

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

    @Lob
    @Column(name = "profile_img", columnDefinition = "LONGBLOB")
    private byte[] profileImg;

    @NotBlank(message = "You must enter a password")
    @Size(min = 8, max =75, message = "The password must have between 8 and 12 characters")
    @Column(name = "password")
    private String password;

    @Email
    @NotBlank
    @Column(name = "user_email")
    private String emailUser;

    @NotNull(message = "You must enter an age ")
    @Min(value = 3, message = "The age must be greater than 3")
    @Max(value = 135, message = "The age must be less than 135")
    @Column(name = "user_age")
    private Integer ageUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = true)
    private UserRole userRole;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte[] profileImg) {
        this.profileImg = profileImg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Integer getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(Integer ageUser) {
        this.ageUser = ageUser;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Users(Integer idUser, String firstName, String userHandle, String lastName, byte[] profileImg, String password, String emailUser, Integer ageUser, UserRole userRole) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.userHandle = userHandle;
        this.lastName = lastName;
        this.profileImg = profileImg;
        this.password = password;
        this.emailUser = emailUser;
        this.ageUser = ageUser;
        this.userRole = userRole;
    }

    public Users(Integer idUser, String userHandle, String emailUser) {
        this.idUser = idUser;
        this.userHandle = userHandle;
        this.emailUser = emailUser;
    }

    public Users() {
    }
}
