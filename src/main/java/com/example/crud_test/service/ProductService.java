package com.example.crud_test.service;

import com.example.crud_test.dto.ProductDto;
import com.example.crud_test.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {
    List<Product> getBestSeller();
    Product getProduct(long id);
    ResponseEntity<?> addProduct(ProductDto productDto);
    ResponseEntity<?> updateProduct(ProductDto productDto);
    List<Product> getAllProductOfShop(long id);
    List<Product> getAllProduct();
}
