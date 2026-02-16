package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Order;
import java.util.List;

public interface OrderDAO {

    public void addOrder(Order order);

    public List<Order> getAll();

    public Order getOrderByID(int id);

    public Order deleteOrder(int id);

}
