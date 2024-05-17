package com.example.firstspringapi.services;

import com.example.firstspringapi.exceptions.ProductNotFoundException;
import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.repositories.CategoryRepository;
import com.example.firstspringapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductServiceBean")
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
//        Fetch the product with the id = id from the DB
//        return productRepository.findById(id);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product with the given ID doesn't exist");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
//        before saving the product, the object of the category should exist
        Category category = product.getCategory();

//        if (category.getId() == null) {
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }

        Product savedProduct = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
