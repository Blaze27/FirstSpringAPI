package com.example.firstspringapi.services;

import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreCategoryServiceBean")
public class FakeStoreCategoryService implements CategoryService{
    CategoryRepository categoryRepository;

    public FakeStoreCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategory() {
        List<Category> response = categoryRepository.findAll();
        System.out.println(response);
        return response;
    }

    @Override
    public List<Product> getProductsInSpecificCategory(Long category_id) {
        return null;
    }
}
