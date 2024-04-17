package com.smtareqaziz.todospringboot.repository;

import com.smtareqaziz.todospringboot.model.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Todo> getAllTodos() {

        return (List<Todo>) entityManager.createQuery("from Todo").getResultList();

    }
    @Transactional
    public void createTodo(Todo todo) {
        entityManager.persist(todo);
    }

    @Transactional
    public void updateTodo(Todo todo) {
        entityManager.merge(todo);
    }

    @Transactional
    public void deleteTodo(String id) {
        entityManager.createQuery("DELETE FROM Todo t WHERE t.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Todo getTodoById(String id) {
        return entityManager.find(Todo.class, id);
    }
}
