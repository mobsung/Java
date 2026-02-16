package org.spring.ecomm.service;

import org.spring.ecomm.dto.ProductCredentialsDTO;
import org.spring.ecomm.dto.ProductDTO;
import org.spring.ecomm.dto.ProductIdCredentialsDTO;

import java.util.List;

public interface ProductService {

    void addProduct(ProductCredentialsDTO dto);

    ProductDTO getProductById(int id);

    List<ProductDTO> getAll();

    ProductDTO deleteProduct(ProductIdCredentialsDTO dto);
}
