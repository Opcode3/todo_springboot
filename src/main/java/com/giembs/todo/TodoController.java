package com.giembs.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // get_all_todo
    @GetMapping("todos")
    public ResponseEntity<ResponseWrapper<List<TodoResponse>>> getAllTodo(){
        return ResponseEntity.ok(new ResponseWrapper<>("successfully retrieved!",todoService.fetchTodos()));
    }
    // get_todo_by_id
    @GetMapping("todo/{id}")
    public ResponseEntity<ResponseWrapper<TodoResponse>> getTodoById(@PathVariable("id") Long id){
        TodoResponse todoResponse = todoService.fetchTodo(id);
        return ResponseEntity.ok(new ResponseWrapper<>("Successfully retrieved!", todoResponse));
    }
    // update_todo_by_id
    @PutMapping("todo/{id}")
    public ResponseEntity<ResponseWrapper<TodoResponse>> updateTodo(@PathVariable("id") Long id, @Valid @RequestBody TodoJSONPayLoad todoJSONPayLoad){
        TodoResponse todoResponse = todoService.editTodo(id, todoJSONPayLoad.getRequest());
        return ResponseEntity.ok(new ResponseWrapper<>("Successfully updated!", todoResponse));
    }

    // update_todo_by_id
    @PostMapping("todo")
    public ResponseEntity<ResponseWrapper<TodoResponse>> addTodo(@Valid @RequestBody TodoJSONPayLoad todoJSONPayLoad){
        TodoResponse todoResponse = todoService.createTodo(todoJSONPayLoad.getRequest());
        return new ResponseEntity<>(new ResponseWrapper<>("Successfully created!", todoResponse), HttpStatus.CREATED);
    }

    // delete_todo_by_id
    @DeleteMapping("todo/{id}")
    public ResponseEntity<ResponseWrapper> deleteTodo(@PathVariable("id") Long id){
        todoService.removeTodo(id);
        return ResponseEntity.ok(new ResponseWrapper("Todo was deleted successfully!"));
    }
    // make_todo_is_complete
    @PatchMapping("todo/{id}")
    public ResponseEntity<ResponseWrapper<TodoResponse>> markCompleteTodo(@PathVariable("id") Long id){
        TodoResponse todoResponse = todoService.completeTodo(id);
        return ResponseEntity.ok(new ResponseWrapper<>("successfully updated", todoResponse));
    }

}
