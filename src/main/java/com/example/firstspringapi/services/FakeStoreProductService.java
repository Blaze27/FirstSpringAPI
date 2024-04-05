package com.example.firstspringapi.services;

import com.example.firstspringapi.dtos.FakeStoreProductDto;
import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertProctuctDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        if (dto != null) {
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setPrice(dto.getPrice());
            product.setDescription(dto.getDescription());
            product.setImage(dto.getImage());
            Category category = new Category();

            category.setDescription(dto.getCategory());
            product.setCategory(category);
        }
        return product;
    }
    @Override
    public Product getProductById(Long id) {
//        Call the FakeStoreAPI to get the product with the given ID
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        First Param: URL to hit
//        Second Param: Type of Response
        return convertProctuctDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
