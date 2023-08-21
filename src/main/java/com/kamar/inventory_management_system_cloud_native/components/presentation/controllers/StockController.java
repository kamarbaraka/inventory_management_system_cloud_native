package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a stock controller to expose all stock management endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/stock", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
@CrossOrigin
public class StockController {
}
