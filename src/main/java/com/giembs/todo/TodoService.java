package com.giembs.todo;

import org.springframework.stereotype.Service;

import java.util.List;


public interface TodoService {
    List<TodoResponse> fetchTodos();
    TodoResponse fetchTodo(Long id);
    TodoResponse editTodo(Long id, TodoRequest todoRequest);
    TodoResponse createTodo(TodoRequest todoRequest);
    void removeTodo(Long id);
    TodoResponse completeTodo(Long id);
}
