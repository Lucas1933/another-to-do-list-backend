package com.lucas_dev.another_todo_list.controllers;

import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserDTO;
import com.lucas_dev.another_todo_list.services.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthorizationController {
    private final AppUserService appUserService;

    public AuthorizationController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO<AppUserDTO>> createUser(@Valid @RequestBody AppUserCreateDTO createUserDTO) {
        AppUserDTO createdUser = appUserService.createUser(createUserDTO);
        ApiResponseDTO<AppUserDTO> response = new ApiResponseDTO<>(createdUser, "User registered correctly", true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/current-user")
    public Authentication getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
