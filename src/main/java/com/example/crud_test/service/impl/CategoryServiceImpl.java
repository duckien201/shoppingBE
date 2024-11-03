package com.example.crud_test.service.impl;

import com.example.crud_test.repository.CategoryRepo;
import com.example.crud_test.dto.CategoryDto;
import com.example.crud_test.model.Category;
import com.example.crud_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public ResponseEntity<?> addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setImage(categoryDto.getImage());
        categoryRepo.save(category);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
