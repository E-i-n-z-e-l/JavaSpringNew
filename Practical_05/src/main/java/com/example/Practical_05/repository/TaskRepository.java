package com.example.Practical_05.repository;

import com.example.Practical_05.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TaskRepository - это интерфейс, расширяющий JpaRepository<Task, Long>.
 * Репозиторий предоставляет методы для выполнения операций сущности Task в базе данных.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Task.TaskStatus status);
    Task findById(long id);
    void deleteById(long id);
}
