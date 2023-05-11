package com.example.todoapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todo_items")      // Name of the table
public class TodoItem {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;

    private Date createDate;
    private Date dueDate;

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }



}
