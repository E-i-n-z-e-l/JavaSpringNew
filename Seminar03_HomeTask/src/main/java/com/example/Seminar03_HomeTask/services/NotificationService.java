package com.example.Seminar03_HomeTask.services;

import com.example.Seminar03_HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    /**
     * Метод для уведомления пользователя.
     * @param user
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Метод для отправки уведомления со строковым сообщением.
     * @param s
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
