package com.example.firstspringapi.repositories;

import com.example.firstspringapi.models.FakeStoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FakeStoreProductRepository extends JpaRepository<FakeStoreProduct, Long> {
    @Override
    Optional<FakeStoreProduct> findById(Long aLong);

    List<FakeStoreProduct> findByTitle(String title);

    List<FakeStoreProduct> findByCategory(String category);

    @Override
    void delete(FakeStoreProduct entity);

    @Override
    FakeStoreProduct save(FakeStoreProduct fakeStoreProduct);
}
