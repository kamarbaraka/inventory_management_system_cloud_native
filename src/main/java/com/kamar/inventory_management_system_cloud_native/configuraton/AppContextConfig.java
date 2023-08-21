package com.kamar.inventory_management_system_cloud_native.configuraton;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * configuration for this application.
 * @author kamar baraka.*/


@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.kamar.inventory_management_system_cloud_native.components"})
@EntityScan(basePackages = {"com.kamar.inventory_management_system_cloud_native.components.persistence.entities"})
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class AppContextConfig {
}
