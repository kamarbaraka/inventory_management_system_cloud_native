package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.report.CustomerReportResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a report controller to expose all reports.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"/report"}, consumes = {"application/json"}, produces = {"application/json"})
@CrossOrigin
public class ReportController {

    public ResponseEntity<CustomerReportResponse> customerReport(){
        return null;
    }
}
