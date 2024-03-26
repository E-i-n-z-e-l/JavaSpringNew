package com.example.Practical_05.model;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data

@Entity // Аннотация @Entity указывает, что этот класс является сущностью, которая будет сохраняться в базе данных;
@Table(name = "tasks") // Аннотация @Table(name = "tasks") говорит Hibernate, что объекты данного класса будут
                       // сохраняться в таблицу с именем "tasks";
public class Task {

    public enum TaskStatus { // Возможные статусы задачи: NOT_STARTED, IN_PROGRESS и COMPLETED;
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED;
    }

    @Id // Аннотация @Id указывает, что поле id является первичным ключом в таблице базы данных;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Аннотация @GeneratedValue(strategy = GenerationType.IDENTITY)
                                                        // указывает, что значение поля id будет автоматически
                                                        // генерироваться базой данных при вставке новой записи;
    private Long id;

    @Column(nullable = false) // @Column(nullable = false) означает, что описание задачи не может быть пустым (null);
    private String description;

    @Enumerated(EnumType.STRING) // @Enumerated(EnumType.STRING) указывает, что значение этого поля будет
                                 // сохраняться как строка (название перечисления TaskStatus), а не как число;
    @Column(nullable = false)
    private TaskStatus status;

    @Column(name = "creation_date", nullable = false) // @Column(name = "creation_date", nullable = false) указывает,
                                                      // что оно соответствует столбцу "creation_date" в таблице
                                                      // базы данных. Оно также не может быть пустым (null);
    private LocalDateTime creationDate;

    /**
     * Метод @PrePersist protected void onCreate() аннотирован аннотацией @PrePersist, что означает, что этот метод
     * будет вызываться автоматически перед сохранением новой записи в базу данных. Он устанавливает текущую дату и
     * время в поле creationDate.
     */
    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
}





