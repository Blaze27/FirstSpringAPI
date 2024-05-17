package com.example.firstspringapi.controllers;

import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(@Qualifier("fakeStoreCategoryServiceBean") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategory() {
        ResponseEntity<List<Category>> responseEntity;
        List<Category> response = categoryService.getAllCategory();

        if (response.isEmpty()) {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }
}
