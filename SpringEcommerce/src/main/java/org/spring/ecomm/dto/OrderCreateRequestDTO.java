package org.spring.ecomm.dto;

import org.spring.ecomm.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderCreateRequestDTO {

    private List<OrderItemDTO> orderedItems = new ArrayList<>();

    public OrderCreateRequestDTO(List<OrderItemDTO> orderedItems) {
        this.orderedItems.addAll(orderedItems);
    }

    public List<OrderItemDTO> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderItemDTO> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
