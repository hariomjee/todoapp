package com.example.todoapp.repository;

import com.example.todoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepo extends JpaRepository<TodoItem,Long> {
}
