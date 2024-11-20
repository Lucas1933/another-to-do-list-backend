package com.lucas_dev.another_todo_list.dtos.todolist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ToDoListCreateDTO(@NotBlank(message = "Title cannot be empty")
                                @Size(min = 1, max = 30)
                                String title) {
}
