package com.lucas_dev.another_todo_list.repositories;

import com.lucas_dev.another_todo_list.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Integer> {
    List<ToDoList> findAllByAppUserId(Integer userId);

}
