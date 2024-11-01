package com.lucas_dev.another_todo_list.dtos.user;

import com.lucas_dev.another_todo_list.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public record UserDTO(String name, String email, LocalDateTime registrationDate, Integer userId) {

    public UserDTO(@NotNull User user) {
        this(user.getName(), user.getEmail(), user.getRegistrationDate(), user.getId());
    }
}
