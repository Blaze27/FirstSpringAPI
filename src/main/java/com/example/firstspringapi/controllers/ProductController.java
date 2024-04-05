package com.example.firstspringapi.controllers;

import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // This Controller class is going to be the REST compliant
@RequestMapping("/products") // localhost:0000/products
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}") // localhost:0000/products/{1} -> Here {1} represents ID
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

//    localhost:0000/products
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

//    Create, Delete, Update, Replace Products
}
