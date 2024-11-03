package com.example.crud_test.dto;

import lombok.Data;

@Data
public class TransferDto {
   private long idUser;
   private int money;
   private String password;
   private String phoneReceiveMoney;
}
