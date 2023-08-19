package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

/**
 * an item entity.
 * @author kamar baraka.*/

@Entity
public class Item {

    @Id
    @GeneratedValue
    private long itemId;

    public long getItemId() {
        return itemId;
    }

    private String itemName;

    private String itemCode;

    private BigDecimal itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
