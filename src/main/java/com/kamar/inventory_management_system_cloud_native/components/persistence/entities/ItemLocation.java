package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * an item location entity.
 * @author kamar baraka.*/

@Entity
public class ItemLocation {

    @Id
    @GeneratedValue
    private long locationId;

    private String section;

    private int isle;

    public long getLocationId() {
        return locationId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }
}
