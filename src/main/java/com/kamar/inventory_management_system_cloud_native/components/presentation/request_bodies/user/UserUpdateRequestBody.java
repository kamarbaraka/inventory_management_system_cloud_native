package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.user;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;

/**
 * request body for user update.
 * @author kamar baraka.*/

public class UserUpdateRequestBody {

    private String username;

    private String password;

    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
