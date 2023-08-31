package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.business.services.BatchManagementService;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.batch.DispatchBatchRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.batch.BatchDispatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * the batch controller.
 * @author kamar baraka.*/

@RestController
public class BatchController {

    private final BatchManagementService batchManagementService;

    @Autowired
    public BatchController(BatchManagementService batchManagementService) {
        this.batchManagementService = batchManagementService;
    }

    @PostMapping(value = {"batch/dispatch"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<BatchDispatchResponse> dispatch(@RequestBody DispatchBatchRequest request){

        /*construct a response*/
        BatchDispatchResponse response = new BatchDispatchResponse();

        /*process the response*/
        this.batchManagementService.dispatchBatch(request);

        /*set the response*/
        response.setMessage("batch dispatched successfully");

        /*return the response*/
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
