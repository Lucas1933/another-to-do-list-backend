package com.lucas_dev.another_todo_list.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;
    private boolean completed;


    public Task() {
    }

    public Task(Integer id, ToDoList toDoList, String name, String description, LocalDateTime creationDate, LocalDateTime completionDate, boolean completed) {
        this.id = id;
        this.toDoList = toDoList;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
