package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * an item order entity.
 * @author kamar baraka.*/

@Entity
public class ItemOrder {

    @Id
    @GeneratedValue
    private long orderId;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private final Collection<Stock> stocks = new ArrayList<>();

    @ManyToOne
    private Transaction transaction;

    private String orderStatus;

    public long getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transaction getBill() {
        return transaction;
    }

    public void setBill(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Collection<Stock> getItems() {
        return stocks;
    }
}
