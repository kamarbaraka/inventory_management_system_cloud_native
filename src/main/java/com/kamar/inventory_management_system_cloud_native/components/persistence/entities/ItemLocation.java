package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * an item location entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class ItemLocation {

    @Id
    @GeneratedValue
    private long locationId;

    private String section;

    private int isle;
}
