package com.lucas_dev.another_todo_list.controllers;

import com.lucas_dev.another_todo_list.configuration.security.AuthenticatedUserService;
import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.response.ApiSimpleResponseDTO;
import com.lucas_dev.another_todo_list.dtos.task.TaskCreateDTO;
import com.lucas_dev.another_todo_list.dtos.task.TaskDTO;
import com.lucas_dev.another_todo_list.dtos.todolist.ToDoListCreateDTO;
import com.lucas_dev.another_todo_list.dtos.todolist.ToDoListDTO;
import com.lucas_dev.another_todo_list.mappers.TaskMapper;
import com.lucas_dev.another_todo_list.mappers.ToDoListMapper;
import com.lucas_dev.another_todo_list.models.Task;
import com.lucas_dev.another_todo_list.models.ToDoList;
import com.lucas_dev.another_todo_list.services.ToDoListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/app/todo-lists")
public class ToDoListController {
    private final ToDoListService toDoListService;
    private final AuthenticatedUserService authenticatedUserService;

    public ToDoListController(ToDoListService toDoListService, AuthenticatedUserService authenticatedUserService) {
        this.toDoListService = toDoListService;
        this.authenticatedUserService = authenticatedUserService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<ToDoListDTO>> createToDoList(@Valid @RequestBody ToDoListCreateDTO toDoListCreateDTO) {
        Integer appUserId = authenticatedUserService.getCurrentUserId();
        ToDoList toDoList = toDoListService.createToDoList(toDoListCreateDTO, appUserId);
        ToDoListDTO toDoListDTO = ToDoListMapper.convertToDTO(toDoList);
        ApiResponseDTO<ToDoListDTO> response = new ApiResponseDTO<>(toDoListDTO, "To do list created successfully", true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{listId}/tasks")
    public ResponseEntity<ApiResponseDTO<TaskDTO>> addTask(@Valid @RequestBody TaskCreateDTO taskCreateDTO, @PathVariable("listId") Integer toDoListId) {
        Task task = toDoListService.addTask(taskCreateDTO, toDoListId);
        TaskDTO taskDTO = TaskMapper.convertToDTO(task);
        URI uri = URI.create("/api/todo-lists/" + toDoListId + "/tasks/" + task.getId());
        ApiResponseDTO<TaskDTO> response = new ApiResponseDTO<>(taskDTO,"task created successfully",true);
        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<ToDoListDTO>>> getAllToDoLists() {
        Integer appUserId = authenticatedUserService.getCurrentUserId();
        List<ToDoList> lists = toDoListService.getAllToDoListsByAppUserId(appUserId);
        List<ToDoListDTO> listsDto = ToDoListMapper.convertToDTOList(lists);
        ApiResponseDTO<List<ToDoListDTO>> response = new ApiResponseDTO<>(listsDto, "Lists obtained successfully", true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSimpleResponseDTO> deleteToDoList(@PathVariable("id") Integer toDoListId) {
        Integer appUserId = authenticatedUserService.getCurrentUserId();
        toDoListService.deleteToDoListById(toDoListId, appUserId);
        ApiSimpleResponseDTO response = new ApiSimpleResponseDTO("To do list with id " + toDoListId + "was deleted", true);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }


}
