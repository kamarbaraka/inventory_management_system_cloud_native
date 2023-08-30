package com.kamar.inventory_management_system_cloud_native.components.business.services;


import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Customer;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){

        this.customerRepository.save(customer);

        return customer;
    }

    public Customer retrieve(String username){

        Customer customer = this.customerRepository.findCustomerByUsername(username);

        return customer;
    }
}
