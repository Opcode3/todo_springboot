package com.giembs.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepo;
    @Override
    public List<TodoResponse> fetchTodos() {
        return todoRepo.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public TodoResponse fetchTodo(Long id) {
        Todo todo = todoRepo.findById(id).orElseThrow( ()-> new RuntimeException("Error: This todo is not in existence."));
        return convertToResponse(todo);
    }

    @Override
    public TodoResponse editTodo(Long id, TodoRequest todoRequest) {
        Todo current_todo = todoRepo.findById(id).orElseThrow( ()-> new RuntimeException("Error: This todo is not in existence."));
        current_todo.setTitle(todoRequest.getTitle());
        current_todo.setDescription(todoRequest.getDescription());
        current_todo.setIsCompleted(todoRequest.getIsCompleted() );
        current_todo.setUpdatedAt(Instant.now());

        Todo just_updated_todo = todoRepo.save(current_todo);
        return convertToResponse(just_updated_todo);
    }

    @Override
    public TodoResponse createTodo(TodoRequest todoRequest) {
        Todo new_todo = Todo.builder()
                .title(todoRequest.getTitle())
                .description(todoRequest.getDescription())
                .isCompleted(todoRequest.getIsCompleted())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        return convertToResponse(todoRepo.save(new_todo));
    }

    @Override
    public void removeTodo(Long id) {
        try{
            todoRepo.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("This todo is not existing.");
        }
    }

    @Override
    public TodoResponse completeTodo(Long id) {
        Todo current_todo = todoRepo.findById(id).orElseThrow( ()-> new RuntimeException("Error: This todo is not in existence."));
        current_todo.setIsCompleted(1);
        current_todo.setUpdatedAt(Instant.now());

        Todo just_updated_todo = todoRepo.save(current_todo);
        return convertToResponse(just_updated_todo);
    }

    private TodoResponse convertToResponse(Todo todo){
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .isCompleted(todo.getIsCompleted())
                .createdAt(LocalDateTime.ofInstant(todo.getCreatedAt(), ZoneId.of("Africa/Lagos")).format(DateTimeFormatter.ISO_DATE_TIME))
                .updatedAt(LocalDateTime.ofInstant(todo.getUpdatedAt(), ZoneId.of("Africa/Lagos")).format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
    }
}
