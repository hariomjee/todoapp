package com.example.todoapp.controller;
import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @GetMapping("/")
    public String allList(Model model){
        List<TodoItem> allList=todoService.getList();
        model.addAttribute("todo",allList);
        return "index";
    }

    @PostMapping("/newTask")
    public String submitNewTask(@RequestParam("title") String title,
                         @RequestParam(value = "createDate" ) @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDateInp ,     // It is necessary to define a pattern while sending date into database.
                          @RequestParam(value = "dueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDateInp)

    {


        System.out.println("date : ->"+createDateInp);
        todoService.newTask(title,createDateInp,dueDateInp);
        return "redirect:/";


    }

    @PostMapping("/action")
    public String handleAction(@RequestParam("action") String action){
        if(action.equals("edit")){
            System.out.println("edit Hariom");
        }
        else if(action.equals("delete")){
          //  System.out.println("delete  vidhi");


        }
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id){
         todoService.deleteTask(id);
        return "redirect:/";
    }



}
