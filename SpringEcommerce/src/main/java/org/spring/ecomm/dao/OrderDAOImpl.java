package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Order;
import org.spring.ecomm.exceptions.OrderNotFoundException;
import org.spring.ecomm.exceptions.ItemAlreadyPresentException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDAOImpl implements OrderDAO{

    Map<Integer, Order> orders = new HashMap<>();

    public void addOrder(Order order){
        if(orders.containsKey(order.getId())){
            throw new ItemAlreadyPresentException("Order ID: " + order.getId() + " already present");
        }
        orders.put(order.getId(), order);
    }

    public List<Order> getAll(){
        return new ArrayList<>(orders.values());
    }

    public Order getOrderByID(int id) {
        if(!orders.containsKey(id)){
            throw new OrderNotFoundException("Order ID: " + id + "absent");
        }
        return orders.get(id);
    }

    public Order deleteOrder(int id){
        if(!orders.containsKey(id)){
            throw new OrderNotFoundException("Order ID: " + id + "absent");
        }
        return orders.remove(id);
    }
}
