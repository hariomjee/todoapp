package com.example.todoapp.service;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoItemRepo todoItemRepo;

    public List<TodoItem> getList() {
        List<TodoItem> todoList = new ArrayList<>();
        todoItemRepo.findAll().forEach(todo1 -> todoList.add(todo1));
        return todoList;
    }

    // method for getting data from pop up and send to server for create new record

    public void newTask(TodoItem todoItem) {
        todoItemRepo.save(todoItem);
    }

    // Updating item by Id
    public void updateTask(Long id, TodoItem updateItem){
        Optional<TodoItem> todoItemOptional= todoItemRepo.findById(id);
        if(todoItemOptional.isPresent()){
            TodoItem todoItem= todoItemOptional.get();
            todoItem.setTitle(updateItem.getTitle());
            todoItem.setCreateDate(updateItem.getCreateDate());
            todoItem.setDueDate(updateItem.getDueDate());
            todoItemRepo.save(todoItem);
        }
        System.out.println("function hitttttttewrewqrrfssfss");
    }

    // Deleted by Id

    public void deleteTask(Long id){
        todoItemRepo.deleteById(id);
    }



}
