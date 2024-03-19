package com.example.Seminar03_HomeTask.services;

import com.example.Seminar03_HomeTask.domain.User;
import com.example.Seminar03_HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* Класс "DataProcessingService" помечен аннотацией "@Service", что означает, что он является сервисом и
выполняет определенные операции с данными.  */
@Service
public class DataProcessingService {

    public UserRepository getRepository() {
        return repository;
    }

    /* Spring будет автоматически внедрять (инъектировать) экземпляр "UserRepository" в это поле при создании
    объекта "DataProcessingService". */
    @Autowired
    private UserRepository repository;


    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }
}
