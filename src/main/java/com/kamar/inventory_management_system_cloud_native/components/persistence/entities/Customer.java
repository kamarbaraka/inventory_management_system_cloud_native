package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * a customer entity.
 * @author kamar baraka.*/

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long customerId;

    private String customerName;

    private String customerContact;

    @ManyToOne
    private Address address;

    public long getCustomerId() {
        return customerId;
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
