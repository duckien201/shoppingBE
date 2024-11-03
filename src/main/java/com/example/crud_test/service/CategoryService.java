package com.example.crud_test.service;

import com.example.crud_test.dto.CategoryDto;
import com.example.crud_test.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<?> addCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
