package com.lucas_dev.another_todo_list.services;

import com.lucas_dev.another_todo_list.dtos.task.TaskCreateDTO;
import com.lucas_dev.another_todo_list.dtos.todolist.ToDoListCreateDTO;
import com.lucas_dev.another_todo_list.models.AppUser;
import com.lucas_dev.another_todo_list.models.Task;
import com.lucas_dev.another_todo_list.models.ToDoList;
import com.lucas_dev.another_todo_list.repositories.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;
    private final AppUserService appUserService;

    public ToDoListService(ToDoListRepository toDoListRepository, AppUserService appUserService) {
        this.toDoListRepository = toDoListRepository;
        this.appUserService = appUserService;
    }


    public Task addTask(TaskCreateDTO taskCreateDTO, Integer toDoListId) {
        ToDoList toDoList = toDoListRepository.findById(toDoListId).orElseThrow(() -> new RuntimeException("To do list could not be found"));
        Task task = new Task(taskCreateDTO.name(), taskCreateDTO.description(), toDoList);
        toDoList.addTask(task);
        toDoListRepository.save(toDoList);
        return task;
    }


    public ToDoList createToDoList(ToDoListCreateDTO toDoList, Integer appUserId) {
        AppUser appUser = appUserService.findUserById(appUserId);
        return toDoListRepository.save(new ToDoList(toDoList.title(), appUser));
    }

    public List<ToDoList> getAllToDoListsByAppUserId(Integer appUserId) {
        return toDoListRepository.findAllByAppUserId(appUserId);
    }

    public void deleteToDoListById(Integer toDoListId, Integer appUserId) {
        ToDoList toDoList = toDoListRepository.findById(toDoListId)
                .orElseThrow(() -> new RuntimeException("ToDoList not found"));

        if (!toDoList.getAppUser().getId().equals(appUserId)) {
            throw new RuntimeException("You are not authorized to delete this ToDoList");
        }

        toDoListRepository.delete(toDoList);
    }

}
