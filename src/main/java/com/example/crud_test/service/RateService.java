package com.example.crud_test.service;

import com.example.crud_test.dto.RateDto;
import com.example.crud_test.model.RateProduct;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RateService {
    public List<RateProduct> getAllRates(long idShop);
    List<RateProduct> getRateProduct(long id);
    ResponseEntity<?> addRateProduct(RateDto rateDto);
    ResponseEntity<?> getRateOfOrderItem(long idOrderItem);
}
