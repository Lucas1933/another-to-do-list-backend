package com.lucas_dev.another_todo_list.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_list_id")
    private ToDoList toDoList;

    private String name;
    private String description;
    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private boolean completed;


    public Task (String name, String description, ToDoList toDoList){
        this.name = name;
        this.description = description;
        this.toDoList = toDoList;
        this.completed = false;
        this.completedAt = null;
    }

}
