package pisith.xyz.todo_list.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    private final TodoRepository todoRepo;

    public List<Todo> todoList() {
        return todoRepo.findAll();
    }

    public Todo saveTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        Todo savedTodo = todoRepo.save(todo);
        log.info("Todo with id {} saved successfully", todo.getId());
        return savedTodo;
    }

    public Todo getTodoById(Integer id) {
        Optional<Todo> optionalTodo = todoRepo.findById(id);
        if (optionalTodo.isPresent()) {
            return optionalTodo.get();
        }
        log.info("Todo with id {} doesn't exist", id);
        return null;
    }

    public Todo updateTodo (Todo todo) {
        Optional<Todo> existingTodo = todoRepo.findById(todo.getId());
        todo.setCreatedAt(existingTodo.get().getCreatedAt());
        todo.setUpdatedAt(LocalDateTime.now());

        Todo updatedTodo = todoRepo.save(todo);
        log.info("Todo with id: {} updated successfully", todo.getId());
        return updatedTodo;
    }

    public void deleteTodoById(Integer id) {
        todoRepo.deleteById(id);
        log.info("Todo with id: {} deleted successfully", id);
    }
}
