package com.lucas_dev.another_todo_list.mappers;

import com.lucas_dev.another_todo_list.dtos.todolist.ToDoListDTO;
import com.lucas_dev.another_todo_list.models.ToDoList;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoListMapper {

    public static ToDoListDTO convertToDTO(ToDoList toDoList) {
        return new ToDoListDTO(
                toDoList.getTitle(),
                toDoList.getCreatedAt(),
                TaskMapper.convertTaskListToDTOList(toDoList.getTasks()),
                toDoList.getId()
        );
    }

    public static List<ToDoListDTO> convertToDTOList(List<ToDoList> toDoLists) {
        return toDoLists.stream()
                .map(ToDoListMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}

