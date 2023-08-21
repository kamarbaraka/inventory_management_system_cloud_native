package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a daemon controller to expose all daemon endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/daemon", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
@CrossOrigin
public class DaemonController {
}
