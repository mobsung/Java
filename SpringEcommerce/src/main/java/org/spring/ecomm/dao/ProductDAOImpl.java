package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.NoProductException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private final Map<Integer, Product> products = new HashMap<>();

    public Product getProduct(int id){
        if(!products.containsKey(id)){
            throw new NoProductException("Product ID: " + id + " absent");
        }
        return products.get(id);
    }

}
