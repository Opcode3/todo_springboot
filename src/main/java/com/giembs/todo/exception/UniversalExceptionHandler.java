package com.giembs.todo.exception;

import com.giembs.todo.ErrorMessage;
import com.giembs.todo.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;

@ControllerAdvice
@ResponseStatus
public class UniversalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorMessage> todoNotFoundException(TodoNotFoundException todoNotFoundException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, todoNotFoundException.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
