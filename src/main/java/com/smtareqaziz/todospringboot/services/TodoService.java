package com.smtareqaziz.todospringboot.services;

import com.smtareqaziz.todospringboot.model.Todo;
import com.smtareqaziz.todospringboot.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public void createTodo(Todo todo) {
        todoRepository.createTodo(todo);
        System.out.println("Todo id : " + todo.getId());
//        return "success";
    }

    public ArrayList<Todo> getAllTodos() {
        return (ArrayList<Todo>) todoRepository.getAllTodos();
    }

    public void updateTodo(Todo todo) {
        todoRepository.updateTodo(todo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteTodo(id);
    }

    public Todo getTodoById(String id) {
        return todoRepository.getTodoById(id);
    }
}
