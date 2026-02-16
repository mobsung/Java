package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Product;
import java.util.List;

public interface ProductDAO {

    public Product getProductById(int id);

    public List<Product> getAll();

}
