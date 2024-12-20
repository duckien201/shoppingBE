package com.example.crud_test.service;

import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<?> agreeProduct(long idProduct);
    ResponseEntity<?> rejectProduct(long idProduct,String reasonReject);
    ResponseEntity<?> rejectReportAccount(long idReport,String reasonReject);
    ResponseEntity<?> getAllReportAccount();
    ResponseEntity<?> getAllReportProduct();
    ResponseEntity<?> acceptReportAccount(long idReportAccount, long idUser, int timeLockAccount);
    ResponseEntity<?> rejectReportProduct(long idReportProduct, String reasonReject);
    ResponseEntity<?> acceptReportProduct(long idReportAccount);
    ResponseEntity<?> getAllOrder();
    ResponseEntity<?> getAllOrderItem();
}
