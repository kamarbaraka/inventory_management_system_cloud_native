package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.user;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.UserResponse;

/**
 * an interface to represent user login response.
 * @author kamar baraka.*/

public class UserLoginResponse implements UserResponse {

    private String message;

    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
