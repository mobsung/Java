package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Order;
import org.spring.ecomm.entity.OrderItem;
import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.NoProductException;
import org.spring.ecomm.exceptions.NoStockException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDAOImpl implements OrderDAO{

    Map<Integer, Order> orders = new HashMap<>();


}
