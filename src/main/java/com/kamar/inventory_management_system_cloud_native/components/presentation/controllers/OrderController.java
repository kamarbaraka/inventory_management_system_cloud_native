package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.business.services.OrderManagementService;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Payment;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ItemOrderAddRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ItemOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentDetails;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * an order controller to expose all order endpoints.
 * @author kamar baraka.*/

@RestController
@CrossOrigin
public class OrderController {

    private OrderManagementService orderManagementService;

    @Autowired
    public OrderController(OrderManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @PostMapping(value = {"order/add"}, consumes = {"application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderAddResponse> add(@RequestBody PaymentDetails requestBody){

        /*get the order*/
        AddOrderResponse addOrderResponse = this.orderManagementService.addOrder(requestBody);

        /*construct order detail*/
        OrderDetails orderDetails = new OrderDetails();

        /*construct a response*/
        OrderAddResponse response = new OrderAddResponse();

        if (addOrderResponse == null){

            response.setMessage("order failed");
            response.setOrderDetails(null);

            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

        /*collect the ordered items*/

        orderDetails.setOrderId(addOrderResponse.getOrder().getOrderId());
        orderDetails.setItemsOrdered(addOrderResponse.getItems());
        orderDetails.setTotalPrice(addOrderResponse.getOrder().getPayment().getPaymentAmount());

        /*set the response*/
        response.setMessage("order successful");
        response.setOrderDetails(orderDetails);

        /*return response*/
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = {"/order/request"}, consumes = {"application/json"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderRequestResponse> request(@RequestBody ItemOrderRequest request){

        /*parse and get the payment*/
        PaymentRequest paymentRequest = this.orderManagementService.requestOrder(request);

        /*construct a response*/
        OrderRequestResponse response = new OrderRequestResponse();

        if (paymentRequest == null){
            /*return an order fail response*/
            response.setMessage("request denied");
            response.setTotalAmount(null);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        response.setMessage("request accepted");
        response.setOrderId(paymentRequest.getOrderId());
        response.setTotalAmount(paymentRequest.getPayment().getPaymentAmount());

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = {"order/update"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.PUT})
    public ResponseEntity<OrderUpdateResponse> update(@RequestBody ItemOrder requestBody){return null;}

    @GetMapping(value = {"order/fetch"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<OrderFetchResponse> fetch(@RequestParam("order_id") String orderId){return null;}

    @DeleteMapping(value = {"order/delete"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<OrderDeleteResponse> delete(@RequestParam("order_id") String orderId){return null;}
}
