package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Payment;

/**
 * the payment request body.
 * @author kamar baraka.*/

public class PaymentRequest {

    private long orderId;

    private Payment payment;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
