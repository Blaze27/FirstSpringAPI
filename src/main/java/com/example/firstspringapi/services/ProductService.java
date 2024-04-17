package com.example.firstspringapi.services;

import com.example.firstspringapi.dtos.FakeStoreProductDto;
import com.example.firstspringapi.exceptions.ProductNotFoundException;
import com.example.firstspringapi.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);

    Product updateProduct(Long id, Product product);

    Product createProduct(Product product);

    void deleteProduct(Long id);
}
