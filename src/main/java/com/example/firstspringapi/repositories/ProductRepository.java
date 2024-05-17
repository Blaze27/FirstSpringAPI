package com.example.firstspringapi.repositories;

import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.projections.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*
JpaRepository<T1, T2> diamond brackets takes two params:
1. Table/object class with which you want to interact.
2. Type of the PrimaryKeyColumn
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findByTitle(String word);

    List<Product> findByTitleContains(String str);

    List<Product> findByTitleAndDescription(String title, String description);

    Optional<Product> findByImage(String url);

    @Override
    void delete(Product entity);

    Product save(Product product);


//    HQL
    @Query("select title as title, description as description from Product where id = :id")
    ProductWithTitleAndDescription fetchTitleAndDescription(@Param("id") Long id);

    @Query(value = "select title as title, description as description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDescription fetchTitleAndDescriptionSQL(@Param("id") Long id);
}
