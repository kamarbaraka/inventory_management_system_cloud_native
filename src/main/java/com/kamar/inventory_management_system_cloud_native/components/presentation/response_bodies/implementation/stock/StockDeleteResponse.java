package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.stock;

/**
 * an interface to present stock delete response.
 * @author kamar baraka.*/

public class StockDeleteResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
