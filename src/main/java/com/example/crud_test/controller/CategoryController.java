package com.example.crud_test.controller;

import com.example.crud_test.repository.CategoryRepo;
import com.example.crud_test.dto.CategoryDto;
import com.example.crud_test.model.Category;
import com.example.crud_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.crud_test.constant.Constant.URL_ORIGIN;

@RestController
@CrossOrigin(URL_ORIGIN)
public class CategoryController {
    @Autowired
    private CategoryRepo repo;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    List<Category> getAllCates() {return categoryService.getAllCategories();}

    @PostMapping("/category/add")
    ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }
}
