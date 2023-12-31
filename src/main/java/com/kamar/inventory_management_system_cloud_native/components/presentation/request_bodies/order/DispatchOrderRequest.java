package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order;

import lombok.Getter;
import lombok.Setter;


/**
 * the request to dispatch an order.
 * @author kamar baraka.*/


@Getter
@Setter
public class DispatchOrderRequest {

    private long[] orderIds;
    private String usernameOfDispatcher;

    private String dispatchLocation;
}
