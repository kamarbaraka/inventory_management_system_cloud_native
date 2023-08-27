package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * response body of the addOrder method.
 * @author kamar baraka.*/

public class AddOrderResponse {

    private final List<String > items = new ArrayList<>();

    private ItemOrder order;

    public List<String> getItems() {
        return items;
    }

    public ItemOrder getOrder() {
        return order;
    }

    public void setOrder(ItemOrder order) {
        this.order = order;
    }
}
