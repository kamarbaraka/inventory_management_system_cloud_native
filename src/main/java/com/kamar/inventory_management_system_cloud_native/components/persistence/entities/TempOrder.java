package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * entity to store temporary orders.
 * @author kamar baraka.*/

@Entity
public class TempOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private LocalTime timePlaced;

    @ManyToOne
    @Cascade(value = CascadeType.DETACH)
    private User customer;

    @OneToMany
    @Cascade(value = CascadeType.ALL)
    private final Collection<ItemOrderDetails> orderDetails = new ArrayList<>();

    private BigDecimal totalAmount;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalTime getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(LocalTime timePlaced) {
        this.timePlaced = timePlaced;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Collection<ItemOrderDetails> getOrderDetails() {
        return orderDetails;
    }
}
