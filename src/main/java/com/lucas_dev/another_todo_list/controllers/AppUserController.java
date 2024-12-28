package com.lucas_dev.another_todo_list.controllers;


import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserDTO;
import com.lucas_dev.another_todo_list.models.AppUser;
import com.lucas_dev.another_todo_list.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/app/users")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<AppUserDTO>> getUserById(@PathVariable Integer id) {
        AppUser appUser = appUserService.findUserById(id);
        AppUserDTO appUserDTO = new AppUserDTO(appUser);
        ApiResponseDTO<AppUserDTO> response = new ApiResponseDTO<>(appUserDTO, "User found successfully", true);
        return ResponseEntity.ok(response);
    }

}

