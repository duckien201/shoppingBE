package com.example.crud_test.service.impl;

import com.example.crud_test.dto.ShopInfoDto;
import com.example.crud_test.model.Product;
import com.example.crud_test.model.RateProduct;
import com.example.crud_test.model.User;
import com.example.crud_test.repository.ProductRepository;
import com.example.crud_test.repository.UserRepository;
import com.example.crud_test.service.RateService;
import com.example.crud_test.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RateService rateService;

    @Override
    public Object getInfoShop(long id) {
        User shop = userRepository.findById(id);
        List<Product> products = productRepository.findByIdShop(id);
        List<RateProduct> allRate = rateService.getAllRates(id);
        return new ShopInfoDto(shop, products, allRate);
    }
}
