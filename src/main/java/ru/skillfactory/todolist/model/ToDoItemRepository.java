package ru.skillfactory.todolist.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
  List<ToDoItem> findAll();
}
