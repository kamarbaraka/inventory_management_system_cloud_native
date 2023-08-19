package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;


import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import io.micrometer.observation.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a rest repository to manage users.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String > {
}
