package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a rest repository to manage user roles.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface UserRoleRepository extends CrudRepository<UserRole, String > {
}
