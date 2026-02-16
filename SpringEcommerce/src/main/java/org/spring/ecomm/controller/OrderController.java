package org.spring.ecomm.controller;

import org.spring.ecomm.dto.OrderCreateRequestDTO;
import org.spring.ecomm.dto.OrderDTO;
import org.spring.ecomm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/ecomm")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(path="/orders/{id}")
    void createOrder(@PathVariable int id, OrderCreateRequestDTO dto){
        service.createOrder(id, dto);
    }

    @PatchMapping(path="/{id}/confirm", produces = "application/json")
    OrderDTO confirmOrder(@PathVariable int id){
        return service.confirmOrder(id);
    }

    @PatchMapping(path="/{id}/ship", produces = "application/json")
    OrderDTO shipOrder(@PathVariable int id){
        return service.shipOrder(id);
    }

    @PatchMapping(path="/{id}/deliver", produces = "application/json")
    OrderDTO deliverOrder(@PathVariable int id){
        return service.deliverOrder(id);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    OrderDTO deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    OrderDTO getOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    @GetMapping(path = "/orders/created", produces = "application/json")
    List<OrderDTO> listCreated(){
        return service.listCreated();
    }

    @GetMapping(path = "/orders/confirmed", produces = "application/json")
    List<OrderDTO> listConfirmed(){
        return service.listConfirmed();
    }

    @GetMapping(path = "/orders/shipped", produces = "application/json")
    List<OrderDTO> listShipped(){
        return service.listShipped();
    }


}
