package org.spring.ecomm.converter;

import org.spring.ecomm.dto.OrderDTO;
import org.spring.ecomm.dto.OrderItemDTO;
import org.spring.ecomm.dto.ProductDTO;
import org.spring.ecomm.entity.Order;
import org.spring.ecomm.entity.OrderItem;
import org.spring.ecomm.entity.Product;

import java.util.List;

public class Converter {

    public static Order OrderDtoEntity(OrderDTO dto){
        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalAmount(dto.getTotalAmount());
        order.setCreatedAt(dto.getCreatedAt());
        order.setStatus(dto.getStatus());
        order.setOrderItemList(ALOrderItemDtoEntity(dto.getOrderItemList()));
        return order;
    }

    public static OrderDTO OrderEntityDto(Order order){
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setStatus(order.getStatus());
        dto.setOrderItemList(ALOrderItemEntityDto(order.getOrderItemList()));
        return dto;
    }

    public static Product ProductDtoEntity(ProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return product;
    }

    public static ProductDTO ProductEntityDto(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        return dto;
    }

    public static OrderItem OrderItemDtoEntity(OrderItemDTO dto){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(dto.getProductId());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setUnitPrice(dto.getUnitPrice());
        return orderItem;
    }

    public static OrderItemDTO OrderItemEntityDto(OrderItem orderItem){
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductId(orderItem.getProductId());
        dto.setQuantity(orderItem.getQuantity());
        dto.setUnitPrice(orderItem.getUnitPrice());
        return dto;
    }

    public static List<Order> ALOrderDtoEntity(List<OrderDTO> dto){
        return dto.stream()
                .map(Converter::OrderDtoEntity)
                .toList();
    }

    public static List<OrderDTO> ALOrderEntityDto(List<Order> order){
        return order.stream()
                .map(Converter::OrderEntityDto)
                .toList();
    }

    public static List<Product> ALProductDtoEntity(List<ProductDTO> dto){
        return dto.stream()
                .map(Converter::ProductDtoEntity)
                .toList();
    }

    public static List<ProductDTO> ALProductEntityDto(List<Product> product){
        return product.stream()
                .map(Converter::ProductEntityDto)
                .toList();
    }

    public static List<OrderItem> ALOrderItemDtoEntity(List<OrderItemDTO> dto){
        return dto.stream()
                .map(Converter::OrderItemDtoEntity)
                .toList();
    }

    public static List<OrderItemDTO> ALOrderItemEntityDto(List<OrderItem> orderItem){
        return orderItem.stream()
                .map(Converter::OrderItemEntityDto)
                .toList();
    }

}
