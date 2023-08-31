package com.kamar.inventory_management_system_cloud_native.components.presentation.controllers;

import com.kamar.inventory_management_system_cloud_native.components.business.services.OrderManagementService;
import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.CompleteOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.DispatchOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ItemOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ReceiveOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentDetails;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * an order controller to expose all order endpoints.
 * @author kamar baraka.*/

@RestController
@CrossOrigin
public class OrderController {

    private final OrderManagementService orderManagementService;

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
    public ResponseEntity<OrderCompleteResponse> update(@RequestBody ItemOrder requestBody){return null;}

    @GetMapping(value = {"order/fetch"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.GET})
    public ResponseEntity<OrderReceiveResponse> fetch(@RequestParam("order_id") String orderId){return null;}

    @DeleteMapping(value = {"order/delete"}, consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(methods = {RequestMethod.DELETE})
    public ResponseEntity<OrderDispatchResponse> delete(@RequestParam("order_id") String orderId){return null;}

    @PostMapping(value = {"/order/dispatch"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderDispatchResponse> dispatch(@RequestBody DispatchOrderRequest request){


        /*construct a response*/
        OrderDispatchResponse response = new OrderDispatchResponse();

        if (request.getOrderIds() == null){
            response.setMessage("its null");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        /*process the request*/
        long batchId = this.orderManagementService.dispatchOrder(request);

        /*set the response*/
        response.setBatchId(batchId);
        response.setMessage("dispatched successfully");

        /*return the response*/
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping(value = {"/order/receive"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderReceiveResponse> receive(@RequestBody ReceiveOrderRequest request){

        /*construct a response*/
        OrderReceiveResponse response = new OrderReceiveResponse();

        /*process the request*/
        this.orderManagementService.receiveOrder(request);

        /*set the response*/
        response.setMessage("order received successfully");

        /*return the response*/
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = {"order/complete"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(methods = {RequestMethod.POST})
    public ResponseEntity<OrderCompleteResponse> complete(@RequestBody CompleteOrderRequest request){

        /*construct a response*/
        OrderCompleteResponse response = new OrderCompleteResponse();

        /*process the request*/
        int points = this.orderManagementService.completeOrder(request);

        /*set the response*/
        response.setMessage("signed successfully, you got "+ points +" more points");

        /*return the response*/
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
