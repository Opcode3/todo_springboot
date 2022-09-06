package com.giembs.todo;


import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private String message;
    private T data;

    ResponseWrapper(String message){
        this.message = message;
        this.data = null;
    }

    ResponseWrapper(String message, T data){
        this.message = message;
        this.data = data;
    }
}
