package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * order response details.
 * @author kamar baraka.*/

@Getter
@Setter
public class OrderDetails {

    private long orderId;

    private List<String > itemsOrdered;

    private BigDecimal totalPrice;

}
