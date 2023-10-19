/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.usermetadata.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author User
 */
@Repository
public interface OrderRepo extends  JpaRepository<Order, Long>{
    Order save(Order order);
    public Object findById(int id);
    List<Order> findByCustomerId(int id);
    public void deleteById(int id);
}
