package com.example.firstspringapi.services;

import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    List<Product> getProductsInSpecificCategory(Long Category_id);
}
