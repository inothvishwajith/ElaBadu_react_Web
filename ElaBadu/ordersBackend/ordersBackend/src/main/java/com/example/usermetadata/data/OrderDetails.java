/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.usermetadata.data;

import javax.persistence.*;

/**
 * @author User
 */
@Entity
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "itemCode")
    private String itemCode;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName="id")
    private Order order;
//    private String orderId;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderDetails(int id, String itemCode, Order order, int qty, double price) {
        this.id = id;
        this.itemCode = itemCode;
        this.order = order;
        this.qty = qty;
        this.price = price;
    }

    public OrderDetails() {
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", order=" + order +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
