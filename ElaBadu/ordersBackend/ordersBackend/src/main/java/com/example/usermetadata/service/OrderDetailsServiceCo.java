/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.usermetadata.service;

import com.example.usermetadata.data.Order;
import com.example.usermetadata.data.OrderDetails;

import java.util.List;

/**
 *
 * @author User
 */
public interface OrderDetailsServiceCo {
    public OrderDetails createOrderDetails(OrderDetails order);

    List<OrderDetails> getAllUOrders();
    List<OrderDetails> getAllOrderDetailsForOrder(int orderId);
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
