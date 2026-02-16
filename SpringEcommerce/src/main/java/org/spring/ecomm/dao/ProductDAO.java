package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Product;
import java.util.List;

public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAll();

    Product deleteProduct(int id);
}
