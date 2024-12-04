package com.lucas_dev.another_todo_list.controllers;

import com.lucas_dev.another_todo_list.dtos.task.TaskCompletionDTO;
import com.lucas_dev.another_todo_list.dtos.task.TaskUpdateDTO;
import com.lucas_dev.another_todo_list.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/app/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Integer taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/completion")
    public ResponseEntity<Void> updateTaskCompletion(@PathVariable("id") Integer taskId, @Valid @RequestBody TaskCompletionDTO taskCompletionDTO){
        taskService.updateTaskCompletionStatus(taskId, taskCompletionDTO);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTaskFields(@PathVariable("id") Integer taskId, @Valid @RequestBody TaskUpdateDTO taskUpdateDto){
        taskService.updateTaskFields(taskId, taskUpdateDto);
        return ResponseEntity.noContent().build();
    }

}
