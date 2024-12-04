package com.lucas_dev.another_todo_list.dtos.task;

import jakarta.validation.constraints.Size;

public record TaskUpdateDTO(
        @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
        String name,

        @Size(min = 1, max = 100, message = "Description must be between 1 and 100 characters")
        String description
) {}
