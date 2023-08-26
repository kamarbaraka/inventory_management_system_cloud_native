package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.OrderAddResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.OrderDeleteResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.OrderFetchResponse;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.OrderUpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * an order controller to expose all order endpoints.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = "/order", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
@CrossOrigin
public class OrderController {

    @PostMapping(value = {"/add"}, consumes = {"application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderAddResponse> add(@RequestBody ItemOrder requestBody){return null;}

    @PutMapping(value = {"/update"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<OrderUpdateResponse> update(@RequestBody ItemOrder requestBody){return null;}

    @GetMapping(value = {"/fetch"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<OrderFetchResponse> fetch(@RequestParam("order_id") String orderId){return null;}

    @DeleteMapping(value = {"/delete"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<OrderDeleteResponse> delete(@RequestParam("order_id") String orderId){return null;}
}
