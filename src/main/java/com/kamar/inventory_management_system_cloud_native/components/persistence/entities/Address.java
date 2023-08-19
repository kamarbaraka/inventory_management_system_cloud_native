package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * an address entity to represent an address.
 * @author kamar baraka.*/

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long addressId;

    private String street;

    private String city;

    private String country;

    private String zipcode;

    public long getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
