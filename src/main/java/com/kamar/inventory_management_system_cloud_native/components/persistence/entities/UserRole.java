package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * a user role entity.
 * @author kamar baraka.*/

@Entity
public class UserRole {

    @Id
    private String roleName;

    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
