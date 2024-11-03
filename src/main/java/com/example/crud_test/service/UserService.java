package com.example.crud_test.service;

import com.example.crud_test.dto.ReportAccountDto;
import com.example.crud_test.dto.ReportProductDto;
import com.example.crud_test.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    ResponseEntity<?> updateUser(User user);
    ResponseEntity<?> updatePhone(User user);
    List<User> getAllUsers();
    ResponseEntity<?> changePassword(long idUser, String oldPassword, String newPassword, String confirmPassword);

    User reloadUser(long idUser);

    ResponseEntity<?> getUserByPhone(String phone);

    ResponseEntity<?> changeStatusAccount(long idUser);

    ResponseEntity<?> resetPassword(long idUser);

    ResponseEntity<?> reportAccount(ReportAccountDto reportAccountDto);

    ResponseEntity<?> reportProduct(ReportProductDto reportProductDto);

}
