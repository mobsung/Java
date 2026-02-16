package org.spring.ecomm.service;

import static org.spring.ecomm.converter.Converter.*;

import org.spring.ecomm.converter.Converter;
import org.spring.ecomm.dao.OrderDAO;
import org.spring.ecomm.dao.ProductDAO;
import org.spring.ecomm.dto.OrderCreateRequestDTO;
import org.spring.ecomm.dto.OrderDTO;
import org.spring.ecomm.entity.Order;
import org.spring.ecomm.entity.OrderItem;
import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.InsufficientStockException;
import org.spring.ecomm.exceptions.InvalidOrderStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO daoOrder;

    @Autowired
    ProductDAO daoProduct;

    public void createOrder(int id, OrderCreateRequestDTO dto) {
        double totalAmount = dto.getOrderedItems().stream()
                .mapToDouble((o1) -> (double) o1.getQuantity() * o1.getProductId())
                .sum();

        Order order = new Order(
                id,
                totalAmount,
                Order.Status.CREATED,
                LocalDate.now()
        );
        order.setOrderItemList(ALOrderItemDtoEntity(dto.getOrderedItems()));

        for(OrderItem p : order.getOrderItemList()) {
            Product product = daoProduct.getProductById(p.getProductId());
            if (product.getStock() - p.getQuantity() < 0) {
                throw new InsufficientStockException("Product ID: " + p.getProductId() + " not enough in stock");
            }
            order.setStatus(Order.Status.CREATED);
            daoOrder.addOrder(order);
        }
    }

    public OrderDTO confirmOrder(int id) {
        Order order = daoOrder.getOrderByID(id);
        if(!order.getStatus().equals(Order.Status.CREATED)){
            throw new InvalidOrderStateException("Order must be confirmed");
        }
        for(OrderItem p : order.getOrderItemList()) {
            Product product = daoProduct.getProductById((p.getProductId()));
            if (product.getStock() - p.getQuantity() < 0) {
                throw new InsufficientStockException("Product ID: " + p.getProductId() + " not enough in stock");
            }
            order.setStatus(Order.Status.CONFIRMED);
        }
        return OrderEntityDto(order);
    }

    public OrderDTO shipOrder(int id){
        Order order = daoOrder.getOrderByID(id);
        if(!order.getStatus().equals(Order.Status.CREATED)) {
            throw new InvalidOrderStateException("Order must be confirmed");
        }
        order.setStatus(Order.Status.SHIPPED);
        return OrderEntityDto(order);
    }

    public OrderDTO deliverOrder(int id){
        Order order = daoOrder.getOrderByID(id);
        if(!order.getStatus().equals(Order.Status.SHIPPED)) {
            throw new InvalidOrderStateException("Order must be shipped");
        }
        order.setStatus(Order.Status.DELIVERED);
        return OrderEntityDto(order);
    }

    public OrderDTO deleteOrder(int id){
        Order order = daoOrder.getOrderByID(id);
        switch (order.getStatus()){
            case CREATED:
                order.setStatus(Order.Status.CANCELLED);
                break;
            case CONFIRMED:
                for(OrderItem oi: order.getOrderItemList()){
                    Product product = daoProduct.getProductById(oi.getProductId());
                    product.setStock(product.getStock() + oi.getQuantity());
                }
                order.setStatus(Order.Status.CANCELLED);
                break;
            case SHIPPED:
                throw new InvalidOrderStateException("Shipped order can't be cancelled");
            default:
                throw new InvalidOrderStateException("The order cant be deleted");
        }
        return OrderEntityDto(order);
    }

    public OrderDTO getOrderById(int id){
        return OrderEntityDto(daoOrder.getOrderByID(id));
    }

    public List<OrderDTO> listCreated(){
        return daoOrder.getAll().stream()
                .filter(o -> o.getStatus().equals(Order.Status.CREATED))
                .map(Converter::OrderEntityDto)
                .toList();
    }

    public List<OrderDTO> listConfirmed(){
        return daoOrder.getAll().stream()
                .filter(o -> o.getStatus().equals(Order.Status.CONFIRMED))
                .map(Converter::OrderEntityDto)
                .toList();
    }

    public List<OrderDTO> listShipped(){
        return daoOrder.getAll().stream()
                .filter(o -> o.getStatus().equals(Order.Status.SHIPPED))
                .map(Converter::OrderEntityDto)
                .toList();
    }
}
