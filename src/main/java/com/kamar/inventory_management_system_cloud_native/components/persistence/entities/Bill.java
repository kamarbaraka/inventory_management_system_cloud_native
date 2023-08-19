package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * a bill entity.
 * @author kamar baraka.*/

@Entity
public class Bill {

    @Id
    @GeneratedValue
    private long billNo;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Payment payment;

    @OneToMany
    private final Collection<Item> itemsOrdered = new ArrayList<>();


    private final LocalDateTime dateTime = LocalDateTime.now();

    public long getBillNo() {
        return billNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Collection<Item> getItemsOrdered() {
        return itemsOrdered;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
