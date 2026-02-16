package org.spring.ecomm.service;

import static org.spring.ecomm.converter.Converter.*;
import org.spring.ecomm.dao.OrderDAO;
import org.spring.ecomm.dao.ProductDAO;
import org.spring.ecomm.dto.ProductCredentialsDTO;
import org.spring.ecomm.dto.ProductDTO;
import org.spring.ecomm.dto.ProductIdCredentialsDTO;
import org.spring.ecomm.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO daoProduct;

    @Autowired
    OrderDAO daoOrder;

    public void addProduct(ProductCredentialsDTO dto){
        daoProduct.addProduct(ProductDtoEntity(dto.getProductDTO()));
    }

    public ProductDTO getProductById(int id){
        return ProductEntityDto(daoProduct.getProductById(id));
    }

    public List<ProductDTO> getAll(){
        return ALProductEntityDto(daoProduct.getAll());
    }

    public ProductDTO deleteProduct(ProductIdCredentialsDTO dto){
        daoOrder.getAll().stream()
                .filter(o -> o.getStatus().equals(Order.Status.CREATED))
                .filter(o -> o.getOrderItemList().stream()
                        .anyMatch(i -> i.getProductId() == dto.getProductID()))
                .forEach(o -> o.setStatus(Order.Status.CANCELLED));
        return ProductEntityDto(daoProduct.deleteProduct(dto.getProductID()));
    }
}
