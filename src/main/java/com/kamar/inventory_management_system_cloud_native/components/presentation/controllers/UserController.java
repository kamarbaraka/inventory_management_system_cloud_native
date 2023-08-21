package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.User;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * a user controller to expose all user endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/user", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
@CrossOrigin
public class UserController {


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
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody Map<String, Object> requestBody){
        return null;}


    /**
     * User login.
     * The Request body must contain the properties;
     * <em>username</em> - the username of the user.
     * <em>password</em> - the password of the user.
     * @param requestBody the body of the request.*/
    /*allowed exposed endpoint and request method*/
    @PostMapping(value = "/login", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<UserLoginResponse> login(@RequestBody User requestBody){return null;}

    @GetMapping(value = "/fetch")
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<UserFetchResponse> fetch(@RequestParam("username") String username){
        return null;
    }

    @PutMapping(value = "/update", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<UserUpdateResponse> update(@RequestBody User requestBody){
        return null;
    }

    @DeleteMapping(value = "/delete", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<UserDeleteResponse> delete(@RequestParam("username") String username){return null;}
}
