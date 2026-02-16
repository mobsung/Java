package org.spring.ecomm.controller;

import org.spring.ecomm.dto.*;
import org.spring.ecomm.service.OrderService;
import org.spring.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/ecomm")
public class OrderController {

    @Autowired
    OrderService service;

    @Autowired
    ProductService productService;

    @PostMapping(path="/orders", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void createOrder(@RequestBody OrderCreateRequestDTO dto){
        service.createOrder(dto);
    }

    @PatchMapping(path="/orders/{id}/confirm", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    OrderDTO confirmOrder(@PathVariable int id){
        return service.confirmOrder(id);
    }

    @PatchMapping(path="/orders/{id}/ship", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    OrderDTO shipOrder(@PathVariable int id){
        return service.shipOrder(id);
    }

    @PatchMapping(path="/orders/{id}/deliver", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    OrderDTO deliverOrder(@PathVariable int id){
        return service.deliverOrder(id);
    }

    @DeleteMapping(path="/orders/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    OrderDTO deleteOrder(@PathVariable int id){
        return service.deleteOrder(id);
    }

    @GetMapping(path="/orders/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    OrderDTO getOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }

    @GetMapping(path = "/orders/created", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List<OrderDTO> listCreated(){
        return service.listCreated();
    }

    @GetMapping(path = "/orders/confirmed", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List<OrderDTO> listConfirmed(){
        return service.listConfirmed();
    }

    @GetMapping(path = "/orders/shipped", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    List<OrderDTO> listShipped(){
        return service.listShipped();
    }

    @PostMapping(path = "/products", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductCredentialsDTO dto){
        productService.addProduct(dto);
    }

    @GetMapping(path = "/products/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping(path = "/products/all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts(){
        return productService.getAll();
    }

    @DeleteMapping(path = "/products", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO deleteProduct(@RequestBody ProductIdCredentialsDTO credentials){
        return productService.deleteProduct(credentials);
    }

}
