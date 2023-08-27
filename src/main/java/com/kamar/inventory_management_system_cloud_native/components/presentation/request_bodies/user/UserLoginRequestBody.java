package com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.user;

/**
 * request body for user login.
 * @author kamar baraka.*/

public class UserLoginRequestBody {

    private String username;

    private String password;

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
}
