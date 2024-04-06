package com.example.firstspringapi.controllers;

import com.example.firstspringapi.dtos.FakeStoreProductDto;
import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.services.ProductService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

//    Create, Delete, Update, Replace Products
}
