package com.example.TodoApplication.TodoApplication.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@SessionAttributes("name")
@Controller
public class TodoController {
    public TodoController(TodoService todoservice){
        super();
        this.todoservice=todoservice;

    }

    private TodoService todoservice;
    @RequestMapping("list-todo")
    public String ListAllTodo(ModelMap model){
        List<Todo>todos =todoservice.findByUserName("ajay");
        model.addAttribute("todos",todos);
        return "listTodos";

    }
}
