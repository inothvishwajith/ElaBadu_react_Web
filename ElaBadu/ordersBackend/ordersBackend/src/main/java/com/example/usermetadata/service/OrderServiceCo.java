/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.usermetadata.service;

import com.example.usermetadata.data.Order;

import java.util.List;

/**
 *
 * @author User
 */
public interface OrderServiceCo {
    public Order createOrder(Order order);

    List<Order> getAllUOrders();
    List<Order> getAllUOrdersByCustomerId(int customerId);
//    public List<UserMetaData> getAllUser();
//
//	public UserMetaData getUserById(int id);
//
//	public List<UserMetaData> getUserByEmail(String email);
//
//	public void deleteUser(int id);
//
//	public UserMetaData updateUser(int id, UserMetaData user);
}
