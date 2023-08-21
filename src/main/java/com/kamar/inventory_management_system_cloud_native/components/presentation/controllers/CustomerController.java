package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a customer controller to expose all customer endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/customer", consumes = {"application/json", "plain/text"}, produces = {"application/json"})
@CrossOrigin
public class CustomerController {
}
