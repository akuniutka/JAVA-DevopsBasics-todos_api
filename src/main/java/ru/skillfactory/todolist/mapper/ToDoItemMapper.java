package ru.skillfactory.todolist.mapper;

import org.springframework.stereotype.Component;
import ru.skillfactory.todolist.dto.ToDoItemDto;
import ru.skillfactory.todolist.model.ToDoItem;

@Component
public class ToDoItemMapper {

  public ToDoItem dtoToModel(ToDoItemDto dto) {
    ToDoItem item = new ToDoItem();
    item.setId(dto.getId());
    item.setDescription(dto.getDescription());
    item.setDone(dto.isDone());
    return item;
  }

  public ToDoItemDto modelToDto(ToDoItem item) {
    ToDoItemDto dto = new ToDoItemDto();
    dto.setId(item.getId());
    dto.setDescription(item.getDescription());
    dto.setDone(item.isDone());
    return dto;
  }
}
