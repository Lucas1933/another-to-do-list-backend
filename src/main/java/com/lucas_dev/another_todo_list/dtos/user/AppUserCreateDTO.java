package com.lucas_dev.another_todo_list.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AppUserCreateDTO(@NotBlank(message = "Name cannot be empty")
                            @Size(min = 3, max = 10)
                            String name,
                               @NotBlank(message = "Email cannot be empty")
                            @Email(message = "Email must be valid")
                            String email,
                               @NotBlank(message = "Password cannot be empty")
                            @Pattern(
                                    regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[A-Za-z\\d]{6,}$",
                                    message = "The password must be at least 6 characters, including at least 1 number, 1 lowercase letter, and 1 uppercase letter."
                            ) String password) {
}
