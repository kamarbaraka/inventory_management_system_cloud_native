package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Customer;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.customer.CustomerDeleteResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.customer.CustomerFetchResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.customer.CustomerRegisterResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.customer.CustomerUpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * a customer controller to expose all customer endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/customer", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
@CrossOrigin
public class CustomerController {

    @PostMapping(value = {"/register"}, consumes = {"application/json", "application/octet-stream"}, produces = {"application/json"})
    @CrossOrigin(methods = RequestMethod.POST)
    public ResponseEntity<CustomerRegisterResponse> register(@RequestBody Customer requestBody){return null;}

    @PutMapping(value = {"/update"}, consumes = {"application/json", "application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<CustomerUpdateResponse> update(@RequestBody Customer requestBody){return null;}

    @GetMapping(value = {"/fetch"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<CustomerFetchResponse> fetch(@RequestParam("username") String username){return null;}

    @DeleteMapping(value = {"/delete"}, consumes = {"application/json", "text/plain"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<CustomerDeleteResponse> delete(@RequestParam("username") String username){return null;}
}
