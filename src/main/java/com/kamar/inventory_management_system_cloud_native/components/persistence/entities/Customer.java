package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;

/**
 * a customer entity.
 * @author kamar baraka.*/

@Entity
public class Customer {

    @Id
    @Column(unique = true)
    private String username;

    private String fullName;

    private String contact;

    private String password;

    @ManyToOne
    private Address address;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] profilePicture;

    public String getUsername() {
        return username;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String customerUsername) {
        this.username = customerUsername;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String customerName) {
        this.fullName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String customerContact) {
        this.contact = customerContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
