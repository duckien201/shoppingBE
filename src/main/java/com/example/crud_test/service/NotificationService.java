package com.example.crud_test.service;

import com.example.crud_test.dto.NotificationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    ResponseEntity<?> getNotificationsByUserId(long userId);
    ResponseEntity<?> readAllNoti(List<NotificationDto> listNotiDto);
}