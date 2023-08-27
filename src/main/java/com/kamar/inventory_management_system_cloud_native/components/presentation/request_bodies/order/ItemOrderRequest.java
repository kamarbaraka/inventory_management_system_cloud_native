package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrderDetails;

import java.util.List;

/**
 * a request for an order.
 * @author kamar baraka.*/

public class ItemOrderRequest {

    private String customerName;

    private List<ItemOrderDetails> items;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemOrderDetails> getItems() {
        return items;
    }

    public void setItems(List<ItemOrderDetails> items) {
        this.items = items;
    }
}
