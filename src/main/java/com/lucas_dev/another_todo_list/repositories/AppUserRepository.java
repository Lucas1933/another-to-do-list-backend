package com.lucas_dev.another_todo_list.repositories;

import com.lucas_dev.another_todo_list.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);
}
