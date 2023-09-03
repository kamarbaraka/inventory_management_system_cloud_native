package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

/*import com.kamar.inventory_management_system_cloud_native.components.business.services.CustomerService;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(value = {"/customer/add"}, consumes = {"application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        Customer customer1 = this.customerService.addCustomer(customer);

        return new ResponseEntity<>(customer1, HttpStatus.CREATED);

    }
}*/
