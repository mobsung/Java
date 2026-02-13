package org.spring.ecomm.service;

import org.spring.ecomm.dao.OrderDAO;
import org.spring.ecomm.dao.ProductDAO;
import org.spring.ecomm.entity.Order;
import org.spring.ecomm.entity.OrderItem;
import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.NoStockException;
import org.spring.ecomm.exceptions.OrnorNotConfirmedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDAO daoOrder;

    @Autowired
    ProductDAO daoProduct;

    public void create(Order order) {
        for(OrderItem p : order.getOrderItemList()) {
            Product product = daoProduct.getProduct(p.getProductId());
            if (product.getStock() - p.getQuantity() < 0) {
                throw new NoStockException("Product ID: " + p.getProductId() + " not enough in stock");
            }
            order.setStatus(Order.Status.CREATED);
        }
    }

    public void confirm(Order order) {
        if(!order.getStatus().equals(Order.Status.CREATED)){
            throw new OrnorNotConfirmedException("Order must be confirmed");
        }
        for(OrderItem p : order.getOrderItemList()) {
            Product product = daoProduct.getProduct(p.getProductId());
            if (product.getStock() - p.getQuantity() < 0) {
                throw new NoStockException("Product ID: " + p.getProductId() + " not enough in stock");
            }
            order.setStatus(Order.Status.CONFIRMED);
        }

    }

}
