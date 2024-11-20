package com.lucas_dev.another_todo_list.dtos.user;

import com.lucas_dev.another_todo_list.models.AppUser;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public record AppUserDTO(String name, String email, LocalDateTime registrationDate, Integer userId) {

    public AppUserDTO(@NotNull AppUser appUser) {
        this(appUser.getName(), appUser.getEmail(), appUser.getCreatedAt(), appUser.getId());
    }
}
