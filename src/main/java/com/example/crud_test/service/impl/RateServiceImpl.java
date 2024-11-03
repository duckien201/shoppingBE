package com.example.crud_test.service.impl;

import com.example.crud_test.repository.OrderItemRepo;
import com.example.crud_test.repository.ProductRepository;
import com.example.crud_test.repository.RateRepository;
import com.example.crud_test.repository.UserRepository;
import com.example.crud_test.dto.RateDto;
import com.example.crud_test.model.Product;
import com.example.crud_test.model.RateProduct;
import com.example.crud_test.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    public List<RateProduct> getAllRates(long idShop) {
        List<Product> allProduct = productRepository.findByIdShop(idShop);
        if (allProduct.isEmpty()) {
            return null;
        } else {
            List<RateProduct> listRateProduct = new ArrayList<>();
            for (Product product : allProduct) {
                List<RateProduct> rateEveryProduct=rateRepository.findRateProductByIdProduct((product.getIdProduct()));
                listRateProduct.addAll(rateEveryProduct);
            }
            return listRateProduct;
        }
    }

    @Override
    public List<RateProduct> getRateProduct(long id) {
        return rateRepository.findRateProductByIdProduct(id);
    }

    @Override
    public ResponseEntity<?> addRateProduct(RateDto rateDto) {
        RateProduct rateProduct = new RateProduct();
        rateProduct.setProduct(productRepository.findByIdProduct(rateDto.getIdProduct()).get());
        rateProduct.setUserRate(userRepository.findById(rateDto.getIdUser()).get());
        rateProduct.setOrderItem(orderItemRepo.findById(rateDto.getIdOrderItem()).get());
        rateProduct.setStar(rateDto.getStar());
        rateProduct.setReview(rateDto.getReview());
        LocalDate date = LocalDate.now();
        Date currentDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        rateProduct.setDateReview(currentDate);
        rateRepository.save(rateProduct);
        return ResponseEntity.ok(rateProduct);
    }

    @Override
    public ResponseEntity<?> getRateOfOrderItem(long idOrderItem) {
        RateProduct rate=rateRepository.findByIdOrderItem(idOrderItem);
        return ResponseEntity.ok(rate);
    }
}
