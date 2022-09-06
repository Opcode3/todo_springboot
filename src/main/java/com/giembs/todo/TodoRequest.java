package com.giembs.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TodoRequest {
    private String title;
    private String description;
    private int isCompleted = 0;
}
