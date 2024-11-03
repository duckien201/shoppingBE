package com.example.crud_test.constant;

import com.example.crud_test.model.User;
import com.example.crud_test.repository.NotificationRepository;
import com.example.crud_test.repository.UserRepository;
import com.example.crud_test.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.crud_test.constant.Constant.UNREAD;
@Service
public class CreateNotification {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public final void createNotification(Long idUser, String image, String title, String content, String url) {
        Notification notification = new Notification();
        notification.setUser(userRepository.findById(idUser).get()); //id của ADMIN
        notification.setImage(image);
        notification.setTitle(title);
        notification.setContent(content);
        notification.setDate(new Date());
        notification.setStatus(UNREAD);
        notification.setUrl(url);
        notificationRepository.save(notification);
    }
}