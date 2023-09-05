package com.kamar.inventory_management_system_cloud_native.components.business.services;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.AddressRepository;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.UserRepository;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.user.UserDeleteRequestBody;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.user.UserLoginRequestBody;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.user.UserUpdateRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * an administrative service to manage the user.
 * @author kamar baraka.*/

@Service
public class UserManagementService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserManagementService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public boolean register(User user){

        /*check if the user exists*/
        if (this.userRepository.findUserByUsername(user.getUsername()) != null)
            return false;

        /*persist the address*/
        this.addressRepository.save(user.getAddress());
        /*persist the user*/
        this.userRepository.save(user);

        return true;
    }

    public User login(UserLoginRequestBody requestBody){

        /*query for the existence of the user*/
        return userRepository.findUserByUsernameAndPassword(requestBody.getUsername(), requestBody.getPassword());
    }

    public User fetch(String username){

        /*query for the user by username*/
        return this.userRepository.findUserByUsername(username);
    }

    @Transactional
    public User update(UserUpdateRequestBody requestBody){

        if (this.userRepository.findUserByUsernameAndPassword(requestBody.getUsername(), requestBody.getPassword()) == null){
            return null;
        }

        User user = requestBody.getUser();

        this.userRepository.deleteUserByUsernameAndPassword(requestBody.getUsername(), requestBody.getPassword());
        this.addressRepository.save(user.getAddress());
        this.userRepository.save(user);

        return user;
    }

    /**
     * deleting a user.
     * @param requestBody the request body for deleting a user.*/
    @Transactional
    public boolean delete(UserDeleteRequestBody requestBody){

        /*delete user*/
        this.userRepository.deleteUserByUsernameAndPassword(requestBody.getUsername(), requestBody.getPassword());

        return true;
    }

    public List<User> users(){

        List<User> userList = new ArrayList<>();
        this.userRepository.findAll().forEach(userList::add);

        return userList;
    }
}
