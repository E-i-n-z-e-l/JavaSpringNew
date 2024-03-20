package com.example.Seminar03_HomeTask.controllers;

import com.example.Seminar03_HomeTask.domain.User;
import com.example.Seminar03_HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер, отвечающий за обработку запросов, связанных с пользователями.
 */
@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {
    @Autowired
    private final RegistrationService service;
    public UserController(RegistrationService service) {
        this.service = service;
    }

    /**
     * Метод, связанный с GET-запросом на /user, который возвращает список пользователей из UserRepository.
     * @return
     */
    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    /**
     * Метод, связанный с POST-запросом на /user/body, который принимает тело запроса в виде объекта User и
     * добавляет его в список пользователей в UserRepository.
     * @param user
     * @return
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }
}