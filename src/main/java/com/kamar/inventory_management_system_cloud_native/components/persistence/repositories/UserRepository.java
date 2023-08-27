package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;


import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

/**
 * a rest repository to manage users.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String > {


    @RestResource
    User findUserByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password);

    @RestResource
    User findUserByUsername(@RequestParam("username") String username);

    User findUserByUsernameAndRole(String username, String role);

    void deleteUserByUsernameAndPassword(String username, String password);
}
