package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order;

import java.math.BigDecimal;

/**
 * order request response.
 * @author kamar baraka.*/

public class OrderRequestResponse {

    private String message;

    private long orderId;
    private BigDecimal totalAmount;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
