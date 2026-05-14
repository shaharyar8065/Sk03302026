package org.example.todoapp.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.todoapp.dto.TodoForm;
import org.example.todoapp.entity.Todo;
import org.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional

public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Todo> findByStatus(String filter){
        return switch (filter == null ? "all" : filter.toLowerCase()){
            case "active"       ->
    todoRepository.findByCompletedOrderByCreatedAtDesc(false);
            case "completed"    ->
    todoRepository.findByCompletedOrderByCreatedAtDesc(true);
            default      ->findAll();

        };
    }

    public Todo findById(Long id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo " +
                        "not found:" + id));
    }
    public Todo create(TodoForm form){
        Todo todo  = Todo.builder()
                .title(form.getTitle().trim())
                .description(form.getDescription())
                .completed(form.isCompleted())
                .build();
        return todoRepository.save(todo);
    }

    public Todo update(Long id, TodoForm form){
        Todo todo = findById(id);
        todo.setTitle(form.getTitle().trim());
        todo.setDescription(form.getDescription());
        todo.setCompleted(form.isCompleted());
        return todoRepository.save(todo);
    }
    public Todo toggleCompleted(Long id){
        Todo todo = findById(id);
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    public void delete(Long id){
        if(!todoRepository.existsById(id)){
            throw new EntityNotFoundException("Todo not found:" + id);
        }
        todoRepository.deleteById(id);
    }
}
