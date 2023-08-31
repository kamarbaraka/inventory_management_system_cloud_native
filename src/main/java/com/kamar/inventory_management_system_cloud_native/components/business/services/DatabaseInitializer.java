package com.kamar.inventory_management_system_cloud_native.components.business.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** a class to initialize the database before the application runs.
 * @author kamar baraka.*/

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    }
}
