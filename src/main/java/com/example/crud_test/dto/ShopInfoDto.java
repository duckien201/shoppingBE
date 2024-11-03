package com.example.crud_test.dto;

import com.example.crud_test.model.Product;
import com.example.crud_test.model.RateProduct;
import com.example.crud_test.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ShopInfoDto {
    private User shop;
    private List<Product> products;
    private List<RateProduct> allRate;


    public ShopInfoDto(User shop, List<Product> products, List<RateProduct> allRate) {
        this.shop = shop;
        this.products = products;
        this.allRate = allRate;
    }
}
