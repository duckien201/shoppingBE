package com.example.crud_test.service.impl;

import com.example.crud_test.constant.Constant;
import com.example.crud_test.repository.NotificationRepository;
import com.example.crud_test.dto.NotificationDto;
import com.example.crud_test.model.Notification;
import com.example.crud_test.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public ResponseEntity<?> getNotificationsByUserId(long userId) {
        List<Notification> list = notificationRepository.findByUserId(userId);
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<?> readAllNoti(List<NotificationDto> listNotiDto) {
        for (NotificationDto notiDto : listNotiDto) {
            // Lấy thông báo theo id
            Notification notification = notificationRepository.findById(notiDto.getId());
            // Cập nhật trạng thái
            notification.setStatus(Constant.READED);
            // Lưu lại thông báo
            notificationRepository.save(notification);
        }
        return ResponseEntity.ok().build();
    }
}
