package com.example.Seminar03_HomeTask.services;

import com.example.Seminar03_HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // @Autowired
    private NotificationService notificationService;

    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Метод, который создает нового пользователя с указанными параметрами имени, возраста и email.
     * @param name
     * @param age
     * @param email
     * @return
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
