package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order;

import lombok.Getter;
import lombok.Setter;

/**
 * the received order request body.
 * @author kamar baraka.*/

@Getter
@Setter
public class ReceiveOrderRequest {

    private long batchId;
    private String recipient;
    private String location;
}
