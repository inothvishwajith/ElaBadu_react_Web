/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.usermetadata.service;

import com.example.usermetadata.data.Order;
import com.example.usermetadata.data.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author User
 */
@Service
public class OrderService implements OrderServiceCo {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllUOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllUOrdersByCustomerId(int customerId) {
        return orderRepo.findByCustomerId(customerId);
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
