package org.spring.ecomm.service;


import org.spring.ecomm.dto.OrderCreateRequestDTO;
import org.spring.ecomm.dto.OrderDTO;
import java.util.List;

public interface OrderService {

    void createOrder(int id, OrderCreateRequestDTO dto);

    OrderDTO confirmOrder(int id);

    OrderDTO shipOrder(int id);

    OrderDTO deliverOrder(int id);

    OrderDTO deleteOrder(int id);

    OrderDTO getOrderById(int id);

    List<OrderDTO> listCreated();

    List<OrderDTO> listConfirmed();

    List<OrderDTO> listShipped();

}
