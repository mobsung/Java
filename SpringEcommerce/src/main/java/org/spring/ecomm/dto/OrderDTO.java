package org.spring.ecomm.dto;

import org.spring.ecomm.entity.Order;
import org.spring.ecomm.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private int id;
    private double totalAmount;
    private Order.Status status;
    private LocalDate createdAt;
    private List<Product> orderItemList = new ArrayList<>();

    public OrderDTO(){}

    public OrderDTO(int id, double totalAmount, Order.Status status, LocalDate createdAt) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order.Status getStatus() {
        return status;
    }

    public void setStatus(Order.Status status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<Product> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<Product> orderItemList) {
        this.orderItemList.addAll(orderItemList);
    }
}
