package com.lucas_dev.another_todo_list.controllers;


import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserDTO;
import com.lucas_dev.another_todo_list.services.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/app/users")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<AppUserDTO>> getUserById(@PathVariable Integer id) {
        AppUserDTO appUserDTO = appUserService.findUserById(id);
        ApiResponseDTO<AppUserDTO> response = new ApiResponseDTO<>(appUserDTO, "User found successfully", true);
        return ResponseEntity.ok(response);
    }

}

