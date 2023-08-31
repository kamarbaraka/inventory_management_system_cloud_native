package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order;

import lombok.Getter;
import lombok.Setter;

/**
 * the complete order request body.
 * @author kamar baraka.*/

@Getter
@Setter
public class CompleteOrderRequest {

    private long orderId;
    private String signer;
    private String location;
}
