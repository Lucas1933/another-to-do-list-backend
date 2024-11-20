package com.lucas_dev.another_todo_list.dtos.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskCreateDTO(@NotBlank(message = "Name cannot be empty")
                            @Size(min = 1, max = 30)
                            String name,
                            @NotBlank(message = "Description cannot be empty")
                            @Size(min = 1, max = 100)
                            String description) {
}
