package com.kamar.inventory_management_system_cloud_native.components.business.services;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.UserRole;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** a class to initialize the database before application runs.
 * @author kamar baraka.*/

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public DatabaseInitializer(UserRoleRepository userRoleRepository){

        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*admin role*/
        UserRole adminRole = new UserRole();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("system administrator");

        /*user role*/
        UserRole userRole = new UserRole();
        userRole.setRoleName("User");
        userRole.setRoleDescription("normal system user");

        /*cashier role*/
        UserRole cashierRole = new UserRole();
        cashierRole.setRoleName("CASHIER");
        cashierRole.setRoleDescription("cashier of the system");

        /*persist the roles*/
        userRoleRepository.save(adminRole);
        userRoleRepository.save(userRole);
        userRoleRepository.save(cashierRole);

    }
}
