package ru.skillfactory.todolist.dto;

import lombok.Data;

@Data
public class ToDoItemDto {
  private Long id;
  private String description;
  private boolean done;
}
