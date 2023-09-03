package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
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
}
