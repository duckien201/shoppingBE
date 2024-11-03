package com.example.crud_test.dto;

import lombok.Data;

@Data
public class RateDto {
    private Long idProduct;
    private Long idUser;
    private Long idOrderItem;
    private int star;
    private String review;
}
