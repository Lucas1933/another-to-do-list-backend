package com.lucas_dev.another_todo_list.services;

import com.lucas_dev.another_todo_list.dtos.user.AppUserCreateDTO;
import com.lucas_dev.another_todo_list.dtos.user.AppUserDTO;
import com.lucas_dev.another_todo_list.exceptions.users.UserExceptions;
import com.lucas_dev.another_todo_list.models.AppUser;
import com.lucas_dev.another_todo_list.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUserDTO createUser(AppUserCreateDTO appUserCreateDTO) {
        String encryptedPassword = passwordEncoder.encode(appUserCreateDTO.password());
        AppUser appUser = AppUser.builder()
                .email(appUserCreateDTO.email())
                .name(appUserCreateDTO.name())
                .password(encryptedPassword)
                .build();
        

        return new AppUserDTO(appUserRepository.save(appUser));
    }

    public AppUserDTO findUserById(Integer id) {
        return appUserRepository.findById(id)
                .map(user -> new AppUserDTO(user))
                .orElseThrow(() -> new UserExceptions.UserNotFoundException("User with id " + id + " not found"));
    }


}
