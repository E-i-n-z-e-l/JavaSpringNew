package com.example.Seminar03_HomeTask.controllers;

import com.example.Seminar03_HomeTask.domain.User;
import com.example.Seminar03_HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Метод, связанный с GET-запросом на /tasks, который возвращает список всех задач.
     * @return
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Метод, связанный с GET-запросом на /tasks/sort, который вызывает метод sortUsersByAge
     * у DataProcessingService для сортировки пользователей по возрасту и возвращает отсортированный
     * список.
     * @return
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")

    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")

    /**
     * Метод, связанный с GET-запросом на /tasks/filter/{age}, который принимает возраст в
     * качестве пути и вызывает метод filterUsersByAge у DataProcessingService для фильтрации
     * пользователей по указанному возрасту и возвращает отфильтрованный список.
     * @param age
     * @return
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Метод, связанный с GET-запросом на /tasks/calc, который вызывает метод calculateAverageAge
     * у DataProcessingService для вычисления среднего возраста пользователей и возвращает результат.
     * @return
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
