/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.usermetadata.service;

import com.example.usermetadata.data.Order;
import com.example.usermetadata.data.OrderDetails;
import com.example.usermetadata.data.OrderDetailsRepo;
import com.example.usermetadata.data.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author User
 */
@Service
public class OrderDetailsService implements OrderDetailsServiceCo {
    @Autowired
    private OrderDetailsRepo orderRepo;

    @Override
    public OrderDetails createOrderDetails(OrderDetails order) {
        return orderRepo.save(order);
    }

    @Override
    public List<OrderDetails> getAllUOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<OrderDetails> getAllOrderDetailsForOrder(int orderId) {
        return orderRepo.findByOrderId(orderId);
    }

//    @Override
//    public List<UserMetaData> getAllUser() {
//        return orderRepo.findAll();
//    }
//
//    @Override
//    public UserMetaData getUserById(int id) {
//        return (UserMetaData) orderRepo.findById(id);
//    }
//
//    @Override
//    public List<UserMetaData> getUserByEmail(String email) {
//        return  orderRepo.findByEmail(email);
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        UserMetaData user = (UserMetaData) orderRepo.findById(id);
//        if (user != null) {
//            orderRepo.delete(user);
//        }
//    }
//
//
//    @Override
//    public UserMetaData updateUser(int id, UserMetaData user) {
//        return orderRepo.save(user);
//    }

}
