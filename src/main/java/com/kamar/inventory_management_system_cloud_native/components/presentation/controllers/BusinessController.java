package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a business controller to expose all business endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/business", consumes = {"application/json", "text/plain"}, produces = {"applicatio/json"})
@CrossOrigin
public class BusinessController {
}
