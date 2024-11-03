package com.example.crud_test.controller;

import com.example.crud_test.dto.NotificationDto;
import com.example.crud_test.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.crud_test.constant.Constant.URL_ORIGIN;

@RestController
@CrossOrigin(URL_ORIGIN)
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/readAllNoti")
    public ResponseEntity<?> readAllNoti(@RequestBody List<NotificationDto> notificationDto) {
        return notificationService.readAllNoti(notificationDto);
    }
}