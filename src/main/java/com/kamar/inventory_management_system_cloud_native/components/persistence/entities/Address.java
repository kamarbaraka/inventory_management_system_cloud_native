package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * an address entity to represent an address.
 * @author kamar baraka.*/

@Entity
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue
    private long addressId;

    private String street;

    private String city;

    private String country;

    private String zipcode;
}
