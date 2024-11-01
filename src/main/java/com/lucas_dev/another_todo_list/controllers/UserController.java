package com.lucas_dev.another_todo_list.controllers;


import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.user.UserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.UserDTO;
import com.lucas_dev.another_todo_list.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<UserDTO>> createUser(@Valid @RequestBody UserCreateDTO createUserDTO) {
        UserDTO createdUser = userService.createUser(createUserDTO);
        ApiResponseDTO<UserDTO> response = new ApiResponseDTO<>(createdUser, "User registered correctly", true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<UserDTO>> getUserById(@PathVariable Integer id) {
        UserDTO userDTO = userService.findUserById(id);
        ApiResponseDTO<UserDTO> response = new ApiResponseDTO<>(userDTO, "User found successfully", true);
        return ResponseEntity.ok(response);
    }

}

