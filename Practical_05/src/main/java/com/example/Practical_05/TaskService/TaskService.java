package com.example.Practical_05.TaskService;

import com.example.Practical_05.model.Task;
import com.example.Practical_05.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Метод, который добавляет новую задачу в базу данных.
     * @param task
     * @return
     */
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Метод, который возвращает список всех задач из базы данных.
     * @return
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Метод, который возвращает список задач с определенным статусом из базы данных.
     * @param status
     * @return
     */
    public List<Task> getTasksByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Метод, который возвращает задачу с указанным идентификатором из базы данных.
     * @param id
     * @return
     */
    public Task getTaskById(long id) {
        return taskRepository.findById(id);
    }

    /**
     * Метод, который сохраняет задачу в базу данных.
     * @param task
     * @return
     */
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Метод, который удаляет задачу с указанным идентификатором из базы данных.
     * @param id
     */
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }
}

