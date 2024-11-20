package com.lucas_dev.another_todo_list.dtos.task;

import java.time.LocalDateTime;

public record TaskDTO(String name, String description, boolean completed, LocalDateTime completedAt,
                      LocalDateTime createdAt, Integer id) {


}
