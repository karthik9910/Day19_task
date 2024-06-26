package com.spring.product.Service;

import com.spring.product.Entity.Product;

import java.util.List;


public interface ProductService {
    void saveProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
