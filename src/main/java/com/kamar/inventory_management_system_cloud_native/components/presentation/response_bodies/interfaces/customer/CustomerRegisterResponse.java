package com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * an interface to present customer register response.
 * @author kamar baraka.*/

@ResponseBody
public class CustomerRegisterResponse {

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
