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

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id);
    }
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

}

