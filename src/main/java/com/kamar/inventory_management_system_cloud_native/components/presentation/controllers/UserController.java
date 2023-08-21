package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.business.services.UserManagementService;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.UserDeleteRequestBody;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.UserLoginRequestBody;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.UserUpdateRequestBody;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * a user controller to expose all user endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/user", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
@CrossOrigin
public class UserController {

    private UserManagementService userManagementService;

    public UserController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    /**
     * Register a user.
     * The request body must contain the following properties;
     * <em>username</em> - the username of the user.
     * <em>first_name</em> - the first name of the user.
     * <em>last_name</em> - the last name of the user.
     * <em>role</em> - the role of the user.
     * <em>street</em> - the street address.
     * <em>city</em> - the city address.
     * <em>country</em> - the country address.
     * <em>password</em> - the user password.
     * <em>profile_picture</em> - The profile picture of the user as bytes.
     * @param requestBody the body of the request.*/
    @PostMapping(value = "/register", consumes = {"application/json", "application/octet-stream"}, produces = {
            "application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody User requestBody){

        UserRegistrationResponse registrationResponse = new UserRegistrationResponse();

        if (!userManagementService.register(requestBody)){
            registrationResponse.setMessage("user exists");
            return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
        }

        registrationResponse.setMessage("accepted");
        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }


    /**
     * User login.
     * The Request body must contain the properties;
     * <em>username</em> - the username of the user.
     * <em>password</em> - the password of the user.
     * @param requestBody the body of the request.*/
    /*allowed exposed endpoint and request method*/
    @PostMapping(value = "/login", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequestBody requestBody){

        UserLoginResponse loginResponse= new UserLoginResponse();
        User user = userManagementService.login(requestBody);

        if (user == null){

            loginResponse.setMessage("no such user");
            loginResponse.setUser(null);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);

        }

        loginResponse.setMessage("success");
        loginResponse.setUser(user);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<UserFetchResponse> fetch(@RequestParam("username") String username){
        UserFetchResponse fetchResponse = new UserFetchResponse();
        User user = userManagementService.fetch(username);

        if (user == null){

            fetchResponse.setMessage("no such user");
            fetchResponse.setUser(null);

            return new ResponseEntity<>(fetchResponse, HttpStatus.OK);
        }

        fetchResponse.setMessage("found");
        fetchResponse.setUser(user);

        return new ResponseEntity<>(fetchResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/update", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<UserUpdateResponse> update(@RequestBody UserUpdateRequestBody requestBody){

        UserUpdateResponse updateResponse = new UserUpdateResponse();

        User user = this.userManagementService.update(requestBody);

        if (user == null){

            updateResponse.setMessage("attempt failed, please check your credentials");
            updateResponse.setUser(null);
            return new ResponseEntity<>(updateResponse, HttpStatus.OK);
        }

        updateResponse.setMessage("successful");
        updateResponse.setUser(user);

        return new ResponseEntity<>(updateResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<UserDeleteResponse> delete(@RequestBody UserDeleteRequestBody requestBody){

        UserDeleteResponse response = new UserDeleteResponse();

        if (!this.userManagementService.delete(requestBody)){

            response.setMessage("failed to delete");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.setMessage("successfully deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
