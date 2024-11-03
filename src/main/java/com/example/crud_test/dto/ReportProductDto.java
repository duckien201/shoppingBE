package com.example.crud_test.dto;

import lombok.Data;

@Data
public class ReportProductDto {
    private String title;
    private String content;
    private long idAccuser;
    private long idProduct;
}
