package com.example.crud_test.service;

import com.example.crud_test.model.User;
import org.springframework.http.ResponseEntity;



public interface AuthService {

    ResponseEntity<?> signin(String headerData);
    ResponseEntity<?> signinAdmin(String headerData);
    ResponseEntity<?> signup(User newUser);
    ResponseEntity<?> sendOtpToReset(String email);
}
