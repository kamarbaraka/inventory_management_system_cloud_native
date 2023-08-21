package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.user;


/**
 * an interface to represent user registration response.
 * @author kamar baraka.*/

public class UserRegistrationResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
