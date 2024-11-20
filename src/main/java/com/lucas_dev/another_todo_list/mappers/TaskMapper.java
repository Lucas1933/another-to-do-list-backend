package com.lucas_dev.another_todo_list.mappers;

import com.lucas_dev.another_todo_list.dtos.task.TaskDTO;
import com.lucas_dev.another_todo_list.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static TaskDTO convertToDTO(Task task) {
        return new TaskDTO(
                task.getName(),
                task.getDescription(),
                task.isCompleted(),
                task.getCompletedAt(),
                task.getCreatedAt(),
                task.getId()
                );
    }

    public static List<TaskDTO> convertTaskListToDTOList(List<Task> tasks) {
        return tasks.stream()
                .map(TaskMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}

