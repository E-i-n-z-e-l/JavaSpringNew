package com.example.Seminar03_HomeTask.services;

import com.example.Seminar03_HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final DataProcessingService dataProcessingService;
    private final UserService userService;
    private final NotificationService notificationService;
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * В этом методе мы сначала вызываем метод createUser у userService для создания нового
     * пользователя. Затем добавляем созданного пользователя в репозиторий через dataProcessingService.
     * И, наконец, вызываем метод notifyUser у notificationService для отправки уведомления о создании
     * нового пользователя.
     */
    public void processRegistration() {
        User newUser = userService.createUser("John Doe", 25, "johndoe@example.com");
        dataProcessingService.getRepository().getUsers().add(newUser);
        notificationService.notifyUser(newUser);
    }
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
