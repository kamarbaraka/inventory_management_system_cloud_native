package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order;

import java.math.BigDecimal;
import java.util.List;

/**
 * order response details.
 * @author kamar baraka.*/

public class OrderDetails {

    private long orderId;

    private List<String > itemsOrdered;

    private BigDecimal totalPrice;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<String> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(List<String> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
