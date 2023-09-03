package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * an item order entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class ItemOrder {

    @Id
    @GeneratedValue
    private long orderId;

    @ManyToOne
    private User customer;

    @OneToMany
    private final Collection<Stock> stocks = new ArrayList<>();

    @ManyToOne
    private Payment payment;

    private String orderStatus;

}
