package com.example.firstspringapi.repositories;

import com.example.firstspringapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
JpaRepository<T1, T2> diamond brackets takes two params:
1. Table/object class with which you want to interact.
2. Type of the PrimaryKeyColumn
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
