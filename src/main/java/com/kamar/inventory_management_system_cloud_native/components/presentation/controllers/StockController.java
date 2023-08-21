package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Stock;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.stock.StockAddResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.stock.StockDeleteResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.stock.StockFetchResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.interfaces.stock.StockUpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * a stock controller to expose all stock management endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/stock", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
@CrossOrigin
public class StockController {

    @PostMapping(value = {"/add"}, consumes = {"application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<StockAddResponse> add(@RequestBody Stock requestBody){return null;}

    @PutMapping(value = {"/update"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<StockUpdateResponse> update(@RequestBody Stock requestBody){return null;}

    @GetMapping(value = {"/fetch"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<StockFetchResponse> fetch(@RequestParam("item_name") String itemName){return null;}

    @DeleteMapping(value = {"/delete"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<StockDeleteResponse> delete(@RequestParam("item_name") String itemName){return null;}
}
