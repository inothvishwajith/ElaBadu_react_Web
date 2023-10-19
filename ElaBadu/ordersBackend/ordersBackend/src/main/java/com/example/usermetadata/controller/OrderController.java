/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.usermetadata.controller;

import com.example.usermetadata.data.BucketItem;
import com.example.usermetadata.data.Order;
import com.example.usermetadata.data.OrderDetails;
import com.example.usermetadata.data.OrderDto;
import com.example.usermetadata.service.OrderDetailsService;
import com.example.usermetadata.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author User
 */
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping(value = "/save")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto order) {
        List<BucketItem> basket = order.getBasket();
        System.out.println(order.getCustomerId());
        Order orders = new Order();
        orders.setOrderDate(order.getOrderDate());
        orders.setCustomerId(order.getCustomerId());
        Order order1 = orderService.createOrder(orders);
        if (order1 != null) {
            for (BucketItem item :
                    basket) {
                System.out.println(item);
                OrderDetails details = new OrderDetails();
                details.setOrder(order1);
                details.setItemCode(item.getId());
                details.setQty(1);
                details.setPrice(item.getPrice());
                orderDetailsService.createOrderDetails(details);
            }
        }
        return new ResponseEntity<Order>(order1, HttpStatus.CREATED);
    }

    //
//
    @GetMapping(value = "/getAllOrders{customerId}")
    public ResponseEntity<List<Order>> getAllOrders(@PathVariable int customerId) {
        System.out.println(customerId);
        return new ResponseEntity<List<Order>>(orderService.getAllUOrdersByCustomerId(customerId), HttpStatus.OK);
    }
    @GetMapping(value = "/getOrderDetails{orderId}")
    public ResponseEntity<List<OrderDetails>> getOrderDetails(@PathVariable int orderId) {
        System.out.println(orderId);
        return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrderDetailsForOrder(orderId), HttpStatus.OK);
    }


//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserMetaData> getUserById(@PathVariable int id) {
//        return new ResponseEntity<UserMetaData>(userService.getUserById(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/getUser{email}")
//    public ResponseEntity<List<UserMetaData>> getUserByEmail(@PathVariable String email) {
//        return new ResponseEntity<List<UserMetaData>>(userService.getUserByEmail(email), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable int id) {
//
//        userService.deleteUser(id);
//        return new ResponseEntity<String>("Delete Sucessfully", HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<UserMetaData> updateUser(@PathVariable int id, @RequestBody UserMetaData user) {
//        return new ResponseEntity<UserMetaData>(userService.updateUser(id, user), HttpStatus.OK);
//    }
}
