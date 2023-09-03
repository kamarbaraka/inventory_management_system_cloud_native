package com.kamar.inventory_management_system_cloud_native.components.business.services;


/*import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Customer;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = {"test.properties"})
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

    @Bean
    public static PropertySourcesPlaceholderConfigurer pspc(){

        return new PropertySourcesPlaceholderConfigurer();
    }

    public Customer retrieve(String username){

        Customer customer = this.customerRepository.findCustomerByUsername(username);

        return customer;
    }

    @Value("${my_name}")
    private static String name;
    public static void printMyName(){

        System.out.println(name);
    }
    
}*/
