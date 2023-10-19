package com.example.usermetadata.data;

import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

public class OrderDto {
    private Date orderDate;
    private int customerId;

    private List<BucketItem> basket;

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                ", basket=" + basket +
                '}';
    }

    public Date getOrderDate() {
        return orderDate;
    }



    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<BucketItem> getBasket() {
        return basket;
    }

    public void setBasket(List<BucketItem> basket) {
        this.basket = basket;
    }

    public OrderDto(Date orderDate, int customerId, List<BucketItem> basket) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.basket = basket;
    }
}
