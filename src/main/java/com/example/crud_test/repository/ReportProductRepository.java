package com.example.crud_test.repository;

import com.example.crud_test.model.ReportProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportProductRepository extends JpaRepository<ReportProduct, Long> {
    ReportProduct findById(long id);
}
