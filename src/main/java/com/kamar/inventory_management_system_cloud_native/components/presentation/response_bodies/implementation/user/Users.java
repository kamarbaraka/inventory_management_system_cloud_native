package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.user;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.UserResponse;

import java.util.Collection;

/**
 * a response for request for all users.
 * @author kamar baraka.*/

public class Users implements UserResponse {

    private String message;

    private Collection<User> users;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
