package com.example.crud_test.repository;

import com.example.crud_test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
     Optional<Product> findByIdProduct(long idProduct);

    @Query("SELECT p FROM Product p WHERE p.shop.id = :id")
    public List<Product> findByIdShop(@Param("id") long idShop);
}
