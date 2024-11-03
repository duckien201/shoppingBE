package com.example.crud_test.repository;

import com.example.crud_test.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findById(int id);
}
