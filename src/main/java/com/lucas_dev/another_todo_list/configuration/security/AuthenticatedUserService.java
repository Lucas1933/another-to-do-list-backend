package com.lucas_dev.another_todo_list.configuration.security;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserService {

    public Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
            return userDetails.getId();
        }

        throw new IllegalStateException("User not authenticated");
    }
}

