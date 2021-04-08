package ru.skillfactory.todolist.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.todolist.dto.ToDoItemDto;
import ru.skillfactory.todolist.mapper.ToDoItemMapper;
import ru.skillfactory.todolist.model.ToDoItem;
import ru.skillfactory.todolist.model.ToDoItemRepository;

@RequiredArgsConstructor
@Service
public class ToDoItemService {

  private final ToDoItemRepository repository;
  private final ToDoItemMapper toDoItemMapper;

  public Collection<ToDoItemDto> findAll() {
    return repository.findAll().stream()
        .map(item -> toDoItemMapper.modelToDto(item))
        .collect(Collectors.toList());
  }

  public ToDoItemDto create(ToDoItemDto dto) {
    ToDoItem toDoItem = toDoItemMapper.dtoToModel(dto);
    ToDoItem save = repository.save(toDoItem);
    return toDoItemMapper.modelToDto(save);
  }

  public Optional<ToDoItemDto> findById(Long id) {
    return repository.findById(id)
        .map(item -> toDoItemMapper.modelToDto(item));
  }

  public ToDoItemDto update(ToDoItemDto dto) {
    Optional<ToDoItem> oldItem = repository.findById(dto.getId());
    return oldItem.map(old -> repository.save(toDoItemMapper.dtoToModel(dto)))
        .map(item -> toDoItemMapper.modelToDto(item))
        .orElseThrow(() -> new RuntimeException("Item with id " + dto.getId() + " not found"));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
