package com.example.Seminar03_HomeTask.repository;

import com.example.Seminar03_HomeTask.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Аннотация "@Component" над классом "UserRepository" указывает, что этот класс является
 * компонентом и может быть использован в других частях программы.
 */
@Component
public class UserRepository {
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<>();
}

/* Класс "UserRepository" представляет собой репозиторий пользователей, который может хранить список
пользователей. Класс имеет приватное поле "users" (пользователи), которое представляет собой список
объектов класса "User". У этого класса есть методы "getUsers()", который возвращает список пользователей,
и "setUsers()", который устанавливает список пользователей. */
