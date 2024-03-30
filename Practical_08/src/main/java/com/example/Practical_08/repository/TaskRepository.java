package com.example.Practical_08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Practical_08.model.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Task.TaskStatus status);
    Task findById(long id);
    void deleteById(long id);
}
