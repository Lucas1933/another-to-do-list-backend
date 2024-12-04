package com.lucas_dev.another_todo_list.services;

import com.lucas_dev.another_todo_list.dtos.task.TaskCompletionDTO;
import com.lucas_dev.another_todo_list.dtos.task.TaskUpdateDTO;
import com.lucas_dev.another_todo_list.models.Task;
import com.lucas_dev.another_todo_list.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    public void updateTaskCompletionStatus(Integer taskId, TaskCompletionDTO taskCompletionDTO) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id " + taskId + " does not exists"));
        task.setCompleted(taskCompletionDTO.isCompleted());
        taskRepository.save(task);
    }

    public void updateTaskFields(Integer taskId, TaskUpdateDTO taskUpdateDto){

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id " + taskId + " does not exists"));

        if (taskUpdateDto.name() == null && taskUpdateDto.description() == null) {
            throw new IllegalArgumentException("At least one field must be provided for update");
        }

        if (taskUpdateDto.name() != null) {
            task.setName(taskUpdateDto.name());
        }
        if (taskUpdateDto.description() != null) {
            task.setDescription(taskUpdateDto.description());
        }

    taskRepository.save(task);
    }
}
