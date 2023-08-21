package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import java.time.LocalDateTime;

/**
 * a user entity.
 * @author kamar baraka.*/

@Entity
public class User {

    @Id
    @Column(unique = true)
    private String username;

    private String firstName;

    private String lastName;

    @OneToOne
    private UserRole role;

    @ManyToOne
    private Address address;

    private String password;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] profilePicture;

    private final LocalDateTime registrationDate = LocalDateTime.now();

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
