package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.stock;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Stock;

/**
 * an interface to present stock fetch response.
 * @author kamar baraka.*/

public class StockFetchResponse {

    private String message;
    private Stock stock;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
