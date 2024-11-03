package com.example.crud_test.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long shopId;
    private Long productId;
    private int quantity;
    private Long price;
}
