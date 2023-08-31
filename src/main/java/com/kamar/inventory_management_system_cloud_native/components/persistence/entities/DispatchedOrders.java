package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * the dispatched orders' entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class DispatchedOrders {

    @Id
    private long orderId;

    @ManyToOne
    private User dispatcher;

    private String dispatchLocation;
    private final LocalDateTime dispatchDate = LocalDateTime.now();
}
