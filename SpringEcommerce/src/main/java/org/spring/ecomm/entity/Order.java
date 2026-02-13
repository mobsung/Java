package org.spring.ecomm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Status{
        CREATED("CREATED"),
        CONFIRMED("CONFIRMED"),
        SHIPPED("SHIPPED"),
        DELIVERED("DELIVERED"),
        CANCELLED("CANCELLED");

        private final String name;

        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private int id;
    private double totalAmount;
    private Status status;
    private LocalDate createdAt;
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(){}

    public Order(int id, double totalAmount, Status status, LocalDate createdAt) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList.addAll(orderItemList);
    }
}
