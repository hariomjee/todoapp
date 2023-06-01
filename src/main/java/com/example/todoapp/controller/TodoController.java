package com.example.todoapp.controller;

import ch.qos.logback.core.model.ImplicitModel;
import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;


    //Method for access all data from Server and show in UI
    @GetMapping("/")
    public String allList(Model model) {
        List<TodoItem> allList = todoService.getList();
        model.addAttribute("todo", allList);
        //System.out.println(allList);

        return "index";
    }

    // Method for create new Task
    @PostMapping("/newTask")
    public String submitNewTask(@RequestParam("title") String title,       // @RequestParam(name).... name field we define into index file.
                                @RequestParam(value = "createDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDateInp,     // It is necessary to define a pattern while sending date into database.
                                @RequestParam(value = "dueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDateInp) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(title);
        todoItem.setCreateDate(createDateInp);
        todoItem.setDueDate(dueDateInp);

        //  System.out.println("date : ->"+createDateInp);
        todoService.newTask(todoItem);
        return "redirect:/";

    }

    @PostMapping("/edit")
    public String showEditModal(@RequestParam(value = "editItemId") Long id,
                                @RequestParam(value = "editTitle") String title,
                                @RequestParam(value = "editCreateDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDateInp,
                                @RequestParam(value = "editDueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDateInp){
            TodoItem todoItem= new TodoItem();
            todoItem.setId(id);
            todoItem.setTitle(title);
            todoItem.setCreateDate(createDateInp);
            todoItem.setDueDate(dueDateInp);

        todoService.updateTask(id,todoItem);

        return "redirect:/";
    }







}
