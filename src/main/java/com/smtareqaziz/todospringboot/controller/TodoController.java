package com.smtareqaziz.todospringboot.controller;

import com.smtareqaziz.todospringboot.model.Todo;
import com.smtareqaziz.todospringboot.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable String id , Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "update";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute("todo") Todo todo) {
        todoService.createTodo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@ModelAttribute("todo") Todo todo) {
        todoService.updateTodo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
