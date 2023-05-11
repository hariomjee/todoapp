package com.example.todoapp.service;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoItemRepo todoItemRepo;

    public List<TodoItem> getList(){
        List<TodoItem> todoList= new ArrayList<>();
        todoItemRepo.findAll().forEach(todo1 -> todoList.add(todo1));
        return todoList;
    }

    // method for getting data from pop up and send to server.

    public void newTask(String title, Date createDate, Date dueDate){
        TodoItem todoItem= new TodoItem();
        todoItem.setTitle(title);
        todoItem.setCreateDate(createDate);
        todoItem.setDueDate(dueDate);
        todoItemRepo.save(todoItem);
    }
    public void deleteTask(Long id){
        todoItemRepo.deleteById(id);
    }
}
