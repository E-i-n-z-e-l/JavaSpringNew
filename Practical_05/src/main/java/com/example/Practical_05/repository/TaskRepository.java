package com.example.Practical_05.repository;

import com.example.Practical_05.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Task.TaskStatus status);
    Task findById(long id);
    void deleteById(long id);
}
