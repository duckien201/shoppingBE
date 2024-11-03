package com.example.crud_test.dto;

import lombok.Data;

@Data
public class CartDto {
    private Long idUser;
    private Long idProduct;
    private int quantity;


}
