package ru.skillfactory.todolist.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class ToDoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "to_do_item_generator")
  @SequenceGenerator(name = "to_do_item_generator", sequenceName = "to_do_item_seq", allocationSize = 1)
  private Long id;
  @NonNull
  private String description;
  @NotNull
  private boolean done;
}
