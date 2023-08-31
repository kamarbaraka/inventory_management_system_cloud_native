package com.kamar.inventory_management_system_cloud_native.components.business.services;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.*;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.*;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.DispatchOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ItemOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.order.ReceiveOrderRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentDetails;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.payment.PaymentRequest;
import com.kamar.inventory_management_system_cloud_native.components.presentation.response_bodies.implementation.order.AddOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * the order management service.
 * @author kamar baraka.*/

@Service
public class OrderManagementService {

    private ItemOrderRepository orderRepository;
    private UserRepository userRepository;
    private StockRepository stockRepository;
    private TransactionRepository transactionRepository;
    private PaymentRepository paymentRepository;
    private TempOrderRepository tempOrderRepository;
    private ItemOrderDetailsRepository orderDetailsRepository;
    private DispatchedOrdersRepository dispatchedOrdersRepository;
    private ReceivedOrdersRepository receivedOrdersRepository;
    private CompletedOrdersRepository completedOrdersRepository;
    private BatchOfOrdersRepository batchOfOrdersRepository;

    @Autowired
    public OrderManagementService(ItemOrderRepository orderRepository, UserRepository userRepository,
                                  StockRepository stockRepository, TransactionRepository transactionRepository,
                                  PaymentRepository paymentRepository, TempOrderRepository tempOrderRepository,
                                  ItemOrderDetailsRepository orderDetailsRepository,
                                  DispatchedOrdersRepository dispatchedOrdersRepository,
                                  ReceivedOrdersRepository receivedOrdersRepository,
                                  CompletedOrdersRepository completedOrdersRepository,
                                  BatchOfOrdersRepository batchOfOrdersRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
        this.transactionRepository = transactionRepository;
        this.paymentRepository = paymentRepository;
        this.tempOrderRepository = tempOrderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.dispatchedOrdersRepository = dispatchedOrdersRepository;
        this.receivedOrdersRepository = receivedOrdersRepository;
        this.completedOrdersRepository = completedOrdersRepository;
        this.batchOfOrdersRepository = batchOfOrdersRepository;
    }

    @Transactional
    public AddOrderResponse addOrder(PaymentDetails request){

        /*construct a response*/
        AddOrderResponse response = new AddOrderResponse();

        /*get the temporary order by id*/
        TempOrder tempOrder = this.tempOrderRepository.findTempOrderByOrderId(request.getOrderId());

        if (tempOrder == null)
            return null;

        /*decrement the stock count*/
        List<ItemOrderDetails> orderDetails = tempOrder.getOrderDetails().stream().toList();
        orderDetails.forEach(detail -> {
            Stock stock = this.stockRepository.findStockByItemName(detail.getItemName());
            stock.setItemCount(stock.getItemCount() - detail.getItemCount());
            response.getItems().add(detail.getItemName());
        });

        /*construct a payment*/
        Payment payment = new Payment();
        payment.setBankName(request.getBankName());
        payment.setAccountName(request.getAccountName());
        payment.setMobileNumber(request.getMobileNumber());
        payment.setPaymentType(request.getPaymentType());
        payment.setPaymentAmount(tempOrder.getTotalAmount());

        /*confirm the order*/
        ItemOrder order = new ItemOrder();
        order.setCustomer(tempOrder.getCustomer());
        order.setPayment(payment);
        order.setOrderStatus("pending");
        this.orderRepository.save(order);

        /*construct and persist the transaction*/
        Transaction transaction = new Transaction();
        transaction.setPayment(payment);
        transactionRepository.save(transaction);

        /*delete the temporary order*/
        this.tempOrderRepository.deleteTempOrderByOrderId(tempOrder.getOrderId());

        /*set the response*/
        response.setOrder(order);

        return response;
    }

    public PaymentRequest requestOrder(ItemOrderRequest request){

        /*check if customer exists*/
        User user = this.userRepository.findUserByUsernameAndRole(request.getCustomerName(), "CUSTOMER");

        if (user == null)
            return null;

        /*get a list of items*/


        /*persist the temporary order*/
        TempOrder order = new TempOrder();
        List<ItemOrderDetails> orderDetails = request.getItems();
        order.setCustomer(user);
        order.getOrderDetails().addAll(orderDetails);
        order.setTimePlaced(LocalTime.now());

        /*get the total amount*/
        List<BigDecimal> amounts = new ArrayList<>();
        orderDetails.forEach(itemOrder -> amounts.add(this.stockRepository.findStockByItemName(
                itemOrder.getItemName()).getItemPrice().multiply(BigDecimal.valueOf(itemOrder.getItemCount()))));
        BigDecimal totalAmount = (BigDecimal) amounts.stream().reduce(BigDecimal::add).stream().toArray()[0];

        order.setTotalAmount(totalAmount);

        this.orderDetailsRepository.saveAll(orderDetails);
        this.tempOrderRepository.save(order);


        /*construct a payment*/
        Payment payment = new Payment();
        payment.setPaymentAmount(totalAmount);

        /*construct and set the payment request*/
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(order.getOrderId());
        paymentRequest.setPayment(payment);

        /*return the payment request*/
        return paymentRequest;
    }

    public long dispatchOrder(DispatchOrderRequest request){

        /*construct the dispatcher of the order*/
        DispatchedOrders dispatchedOrder = new DispatchedOrders();
        /*construct a batch*/
        BatchOfOrders batch = new BatchOfOrders();

        request.getOrderIds().forEach(orderId -> {
            /*get the order from the database*/
            ItemOrder order = this.orderRepository.findItemOrderByOrderId(orderId);
            /*get the user who dispatched the order*/
            User dispatcher = this.userRepository.findUserByUsername(request.getUsernameOfDispatcher());

            /*set the dispatched order*/
            dispatchedOrder.setOrderId(order.getOrderId());
            /*set the dispatcher*/
            dispatchedOrder.setDispatcher(dispatcher);
            /*set the dispatch location*/
            dispatchedOrder.setDispatchLocation(request.getDispatchLocation());

            /*set and persist the order status*/
            order.setOrderStatus("Dispatched");
            this.orderRepository.save(order);

            /*set the batch location*/
            batch.setLocation(request.getDispatchLocation());
            /*set the batch status (release the batch)*/
            batch.setStatus("released");
            /*add the order*/
            batch.getOrders().add(order);

        });

        /*on success return true*/
        return batch.getBatchId();
    }

    public boolean receiveOrder(ReceiveOrderRequest request){

        /*construct received orders*/
        ReceivedOrders receivedOrder = new ReceivedOrders();

        /*get the batch*/
        BatchOfOrders batch = this.batchOfOrdersRepository.findBatchOfOrdersByBatchId(request.getBatchId());
        /*get the recipient*/
        User recipient = this.userRepository.findUserByUsername(request.getRecipient());

        /*get and update the orders*/
        batch.getOrders().forEach(order -> {

            /*set and persist the order*/
            receivedOrder.setOrderId(order.getOrderId());
            receivedOrder.setRecipient(recipient);
            receivedOrder.setReceiveLocation(request.getLocation());
            this.receivedOrdersRepository.save(receivedOrder);
        });

        /*update the batch*/
        String location = request.getLocation();
        if (batch.getLocation().equals(location)){

            batch.setStatus("completed");
            this.batchOfOrdersRepository.save(batch);
            return true;
        }

        batch.setStatus("transit");
        this.batchOfOrdersRepository.save(batch);
        return true;
    }

    public boolean completeOrder(){
        return true;
    }
}
