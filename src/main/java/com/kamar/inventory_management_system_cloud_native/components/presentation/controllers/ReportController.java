package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.business.services.ReportingService;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.report.CustomerReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a report controller to expose all reports.
 * @author kamar baraka.*/

@RestController
@CrossOrigin
public class ReportController {

    private final ReportingService reportingService;

    @Autowired
    public ReportController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    public ResponseEntity<CustomerReportResponse> customerReport(){
        return null;
    }

    @GetMapping(value = {"/report/order"})
    public ResponseEntity<byte[]> orderReport() throws Exception{

        byte[] report = null;

        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
