package com.lucas_dev.another_todo_list.services;

import com.lucas_dev.another_todo_list.dtos.user.UserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.UserDTO;
import com.lucas_dev.another_todo_list.exceptions.users.UserExceptions;
import com.lucas_dev.another_todo_list.models.ToDoList;
import com.lucas_dev.another_todo_list.models.User;
import com.lucas_dev.another_todo_list.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO){
    User user = new User(userCreateDTO.name(),userCreateDTO.email(),userCreateDTO.password());
    return new UserDTO(userRepository.save(user));
    }

    public UserDTO findUserById(Integer id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO(user)) // Transforma User a UserDTO si está presente
                .orElseThrow(() -> new UserExceptions.UserNotFoundException("User with id " + id + " not found"));
    }

}
