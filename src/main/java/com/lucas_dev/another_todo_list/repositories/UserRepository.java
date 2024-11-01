package com.lucas_dev.another_todo_list.repositories;

import com.lucas_dev.another_todo_list.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
