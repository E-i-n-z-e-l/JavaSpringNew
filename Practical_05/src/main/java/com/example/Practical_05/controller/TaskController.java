package com.example.Practical_05.controller;

import com.example.Practical_05.TaskService.TaskService;
import com.example.Practical_05.model.Task;
import com.example.Practical_05.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // аннотация, которая указывает, что этот класс является контроллером веб-службы REST;
@RequestMapping("/tasks") // аннотация, которая указывает базовый путь для всех методов в этом контроллере;
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    /**
     * Метод, который добавляет новую задачу, полученную в теле запроса.
     * @param task
     * @return
     */
    @PostMapping // аннотация указывает, что этот метод обрабатывает HTTP POST запросы;
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * Метод, который возвращает список всех задач.
     * @return
     */
    @GetMapping // аннотация указывает, что этот метод обрабатывает HTTP GET запросы;
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Метод, который возвращает список задач с указанным статусом, полученным из пути запроса (@PathVariable).
     * @param status
     * @return
     */
    @GetMapping("/status/{status}") // аннотация указывает, что этот метод обрабатывает HTTP GET запросы с динамическим параметром /status/{status};
    public List<Task> getTasksByStatus(@PathVariable Task.TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    /**
     * Метод, который обновляет статус существующей задачи с указанным идентификатором. Он получает идентификатор
     * из пути запроса (@PathVariable) и обновленную задачу из тела запроса (@RequestBody).
     * @param id
     * @param task
     * @return
     */
    @PutMapping("/{id}") // аннотация указывает, что этот метод обрабатывает HTTP PUT запросы с динамическим параметром /{id};
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getTaskById(id);
        existingTask.setStatus(task.getStatus());
        return taskService.saveTask(existingTask);
    }

    /**
     * Метод, который удаляет задачу с указанным идентификатором, полученным из пути запроса (@PathVariable).
     * @param id
     */
    @DeleteMapping("/{id}") // аннотация указывает, что этот метод обрабатывает HTTP DELETE запросы с динамическим параметром /{id};
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}


