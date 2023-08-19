package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.Collection;

/**
 * an item inventory entity.
 * @author kamar baraka*/

@Entity
public class ItemInventory {

    @Id
    private String inventoryName;

    @OneToMany
    private final Collection<Item> itemCollection = new ArrayList<>();

    private int itemCount;

    @OneToOne
    private ItemLocation location;

    public String getInventoryName() {
        return inventoryName;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public ItemLocation getLocation() {
        return location;
    }

    public void setLocation(ItemLocation location) {
        this.location = location;
    }
}
