package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private final Map<Integer, Product> products = new HashMap<>();

    public Product getProductById(int id){
        if(!products.containsKey(id)){
            throw new ProductNotFoundException("Product ID: " + id + " absent");
        }
        return products.get(id);
    }

    public List<Product> getAll(){
        return new ArrayList<>(products.values());
    }

}
