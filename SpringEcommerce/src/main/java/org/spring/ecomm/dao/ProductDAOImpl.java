package org.spring.ecomm.dao;

import org.spring.ecomm.entity.Product;
import org.spring.ecomm.exceptions.ItemAlreadyPresentException;
import org.spring.ecomm.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private boolean isPermitted;

    private final Map<Integer, Product> products = new HashMap<>();

    public ProductDAOImpl(){
        products.put(
                1, new Product(1, "pen", 2.2, 10)
        );
        products.put(
                2, new Product(2, "phone", 1000, 20)
        );
        products.put(
                3, new Product(3, "tv", 600.99, 3)
        );
        products.put(
                4, new Product(4, "mouse", 20.5, 10)
        );
        products.put(
                5, new Product(5, "keyboard", 60.29, 10)
        );
        products.put(
                6, new Product(6, "monitor", 250.75, 5)
        );

        products.put(
                7, new Product(7, "laptop", 1200.00, 8)
        );

        products.put(
                8, new Product(8, "tablet", 450.50, 12)
        );

        products.put(
                9, new Product(9, "headphones", 89.99, 15)
        );

        products.put(
                10, new Product(10, "printer", 179.49, 4)
        );
    }

    public void addProduct(Product product){
        if(products.containsKey(product.getId())){
            throw new ItemAlreadyPresentException("Product ID: " + product.getId() + "already in stock");
        }
        products.put(product.getId(), product);
    }


    public Product getProductById(int id){
        if(!products.containsKey(id)){
            throw new ProductNotFoundException("Product ID: " + id + " absent");
        }
        return products.get(id);
    }

    public List<Product> getAll(){
        return new ArrayList<>(products.values());
    }

    public Product deleteProduct(int id){
        if(!products.containsKey(id)){
            throw new ProductNotFoundException("Product ID: " + id + "absent");
        }
        return products.remove(id);
    }
}
