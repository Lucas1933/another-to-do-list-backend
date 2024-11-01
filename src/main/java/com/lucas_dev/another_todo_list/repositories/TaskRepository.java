package com.lucas_dev.another_todo_list.repositories;

import com.lucas_dev.another_todo_list.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
