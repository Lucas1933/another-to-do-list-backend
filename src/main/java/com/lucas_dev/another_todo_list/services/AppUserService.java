package com.lucas_dev.another_todo_list.services;

import com.lucas_dev.another_todo_list.dtos.user.AppUserCreateDTO;
import com.lucas_dev.another_todo_list.exceptions.EmailAlreadyExistsException;
import com.lucas_dev.another_todo_list.exceptions.users.UserExceptions;
import com.lucas_dev.another_todo_list.models.AppUser;
import com.lucas_dev.another_todo_list.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser createUser(AppUserCreateDTO appUserCreateDTO) {
        Optional<AppUser> appUserFromDb =appUserRepository.findByEmail(appUserCreateDTO.email());
        if(appUserFromDb.isPresent()){
            throw new EmailAlreadyExistsException("Email "+appUserCreateDTO.email()+" already exists");
        }

        String encryptedPassword = passwordEncoder.encode(appUserCreateDTO.password());
        AppUser appUser = new AppUser(appUserCreateDTO.name(),appUserCreateDTO.email(),encryptedPassword);
        return appUserRepository.save(appUser);
    }
    public AppUser findUserById(Integer appUserId) {
        return appUserRepository.findById(appUserId)
                .orElseThrow(() -> new UserExceptions.UserNotFoundException("User with id " + appUserId + " not found"));
    }}
