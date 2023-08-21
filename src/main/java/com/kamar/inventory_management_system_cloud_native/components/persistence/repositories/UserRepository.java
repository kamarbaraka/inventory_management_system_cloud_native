package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;


import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import io.micrometer.observation.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a rest repository to manage users.
 * @author kamar baraka.*/

@RepositoryRestResource
@RequestMapping(value = {"/admin/user"})
public interface UserRepository extends CrudRepository<User, String > {
}
