package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * a bill entity.
 * @author kamar baraka.*/

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private long transactionId;

    @ManyToOne
    private Payment payment;


    private final LocalDateTime dateTime = LocalDateTime.now();

    public long getTransactionId() {
        return transactionId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
