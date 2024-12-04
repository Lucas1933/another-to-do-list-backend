package com.lucas_dev.another_todo_list.controllers;

import com.lucas_dev.another_todo_list.dtos.response.ApiResponseDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserDTO;
import com.lucas_dev.another_todo_list.models.AppUser;
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
    public ResponseEntity<ApiResponseDTO<AppUserDTO>> createUser(@Valid @RequestBody AppUserCreateDTO appUserCreateDTO) {
        AppUser appUser = appUserService.createUser(appUserCreateDTO);
        AppUserDTO appUserDTO = new AppUserDTO(appUser);
        ApiResponseDTO<AppUserDTO> response = new ApiResponseDTO<>(appUserDTO, "User registered correctly", true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/current-user")
    public Authentication getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}
