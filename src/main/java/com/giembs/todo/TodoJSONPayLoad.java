package com.giembs.todo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TodoJSONPayLoad {
    @JsonProperty(value = "todo_title")
    @NotNull
    @NotEmpty
    private String title;

    @JsonProperty(value = "todo_desc")
    @NotNull
    @NotEmpty
    private String description;

    @JsonProperty(value = "is_complete")
    private int isCompleted;


    public TodoRequest getRequest(){
        return TodoRequest.builder()
                .title(title)
                .description(description)
                .isCompleted(isCompleted)
                .build();
    }
}
