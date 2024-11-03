package com.example.crud_test.service;

import com.example.crud_test.dto.CartDto;
import com.example.crud_test.model.Cart;
import org.springframework.http.ResponseEntity;

public interface CartService {
    public Cart addCart(CartDto cartDto);
    ResponseEntity<?> deleteCart(long idCart);
    ResponseEntity<?> deleteAllCart(long idUser);
    ResponseEntity<?> getCartByIdUser(long idUser);
    ResponseEntity<?> handleQuantity(long idCart,int quantity);
}
