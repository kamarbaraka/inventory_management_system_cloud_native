package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;

/**
 * a customer entity.
 * @author kamar baraka.*/

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"customer_username", })
)
public class Customer {

    @Id
    @GeneratedValue
    private long customerId;

    private String customerUsername;

    private String customerName;

    private String customerContact;

    private String password;

    @ManyToOne
    private Address address;

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
