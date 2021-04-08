package ru.skillfactory.todolist.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory.todolist.dto.ToDoItemDto;
import ru.skillfactory.todolist.service.ToDoItemService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ToDoItemController {

  private final ToDoItemService toDoItemService;

  @GetMapping("/items")
  Collection<ToDoItemDto> items() {
    log.info("Request to get all items");
    Collection<ToDoItemDto> all = toDoItemService.findAll();
    log.info(all.toString());
    return all;
  }

  @GetMapping("/item/{id}")
  ResponseEntity<?> getItem(@PathVariable Long id) {
    log.info("Request to get item with id: {}", id);
    Optional<ToDoItemDto> group = toDoItemService.findById(id);
    return group.map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/item")
  ResponseEntity<ToDoItemDto> createItem(@RequestBody ToDoItemDto dto) throws URISyntaxException {
    log.info("Request to create item: {}", dto);
    ToDoItemDto result = toDoItemService.create(dto);
    return ResponseEntity.created(new URI("/api/item/" + result.getId()))
        .body(result);
  }

  @PutMapping("/item/{id}")
  ResponseEntity<ToDoItemDto> updateItem(@RequestBody ToDoItemDto dto) {
    log.info("Request to update item: {}", dto);
    ToDoItemDto result = toDoItemService.update(dto);
    return ResponseEntity.ok().body(result);
  }

  @DeleteMapping("/item/{id}")
  public ResponseEntity<?> deleteItem(@PathVariable Long id) {
    log.info("Request to delete item: {}", id);
    toDoItemService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
