package com.lucas_dev.another_todo_list.dtos.todolist;

import com.lucas_dev.another_todo_list.dtos.task.TaskDTO;
import com.lucas_dev.another_todo_list.models.Task;
import com.lucas_dev.another_todo_list.models.ToDoList;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record ToDoListDTO(String title, LocalDateTime creationDate, List<TaskDTO> tasks, Integer id) {
}
